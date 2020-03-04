package com.etlsolutions.gwise.system;

import com.etlsolutions.gwise.data.GwiseDataUnit;
import com.etlsolutions.javafx.MainApp;
import static com.etlsolutions.gwise.system.SettingConstants.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.area.GwiseAreaBean;
import com.etlsolutions.gwise.data.area.GwiseAreaRootBean;
import com.etlsolutions.gwise.data.area.GwiseGardenAreaBean;
import com.etlsolutions.gwise.data.basicshape.GwiseShapeType;
import com.etlsolutions.gwise.data.log.GwiseLogGroupRootBean;
import com.etlsolutions.gwise.data.other.GwiseGrowingMediumBean;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupBean;
import com.etlsolutions.gwise.data.plant.GwisePlantGroupRootBean;
import com.etlsolutions.gwise.data.plant.GwisePlantVarietyBean;
import com.etlsolutions.gwise.data.plant.PlantTypeBean;
import com.etlsolutions.gwise.data.subarea.GwisePlantBedBean;
import com.etlsolutions.gwise.data.subarea.GwiseSubAreaType;
import com.etlsolutions.gwise.data.subarea.SubareaLogoItem;
import com.etlsolutions.javafx.data.other.GrowingMediumGroup;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.subarea.location.LocationFactory;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.other.FertiliserFactory;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ProjectManager ONLY manage the currently-opened project.
 *
 * @author zc
 */
public final class ProjectManager {

    public static final String PROJECT_PROPERTY = ProjectManager.class.getName() + ".PROJECT_PROPERTY";

    private static final ProjectManager INSTANCE = new ProjectManager();

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private final ObjectMapper mapper = new ObjectMapper();
    private ProjectConfiguration configuration;
    private final List<SubareaLogoItem> subareaLogoItems;
    private final ValueWrapper<ProjectContents> contentsValueWrapper = new ValueWrapper<>(null);
    private final Map<Integer, DataUnit> dataMap = new HashMap<>();
    private final Properties properties = GwiseRepository.getInstance().getProperties();

    private final ValueWrapper<GwiseProjectContents> gwiseProjectContentsWrapper = new ValueWrapper<>(null);
    private final Map<Integer, GwiseDataUnit> gwiseDataMap = new HashMap<>();

    /**
     * The ValueWrapper for the selected DataUnit is used to synchronise the
     * selection among view, editor and pallette.
     */
    private final ValueWrapper<DataUnit> selectedDataUnitValueWrapper = new ValueWrapper<>(null);
    private final ValueWrapper<GwiseDataUnit> selectedGwiseDataUnitValueWrapper = new ValueWrapper<>(null);

    private ProjectManager() {
        subareaLogoItems = loadSubareaLogoItems();
    }

    public static ProjectManager getInstance() {
        return INSTANCE;
    }

    void init() throws IOException {

        String path = properties.getProperty(CURRENT_RPOJECT_PATH_KEY);
        if (path != null) {
            File directory = new File(path);
            if (directory.isDirectory()) {
                boolean success = loadProject(path);
                if (!success && directory.list().length == 0) {
                    initContents();
                }
            }
        } else {

            configuration = new ProjectConfiguration(null, null, null);
            initContents();
        }
    }

    private void initContents() throws IOException {

        ProjectContents contents = new ProjectContents();
        contents.setGrowingMediums(RepositoryManager.getInstance().loadDefaultData(DEFAULT_DATA_DIRECTORY + File.separator + GrowingMediumGroup.class.getSimpleName() + SettingConstants.JSON_FILE_EXTENSION, GrowingMediumGroup.class).getGrowingMediums());
        contents.setFertilisers(FertiliserFactory.getInstance().getDefaultFertilisers());
        contents.setLiquidFertilisers(FertiliserFactory.getInstance().getDefaultLiquidFertilisers());
        contents.setLocationDirections(LocationFactory.getInstance().getDefaultLocationDirections());
        contents.setLocationReferencePoints(LocationFactory.getInstance().getDefaultLocationReferencePoints());
        contents.setContainerShapes(LocationFactory.getInstance().getDefaultContainerShape());
        contents.setFlowerTypes(LogFactory.getInstance().getDefaultFlowerTypes());
        contents.setFlowerColors(LogFactory.getInstance().getDefaultFlowerColors());
        contents.setFruitShapes(LogFactory.getInstance().getDefaultFruitShapes());
        contents.setFruitColors(LogFactory.getInstance().getDefaultFruitColors());
        contents.setFertiliserUoms(FertiliserFactory.getInstance().getDefaultFertiliserUoms());
        contents.setWateringAmountUoms(LogFactory.getInstance().getDefaultWaterAmountUoms());
        contents.setWateringFluxUoms(LogFactory.getInstance().getDefaultWaterFluxUoms());
        contents.setSolidFertiliserDensityUoms(DefaultListFactory.getInstance().getDefaultSolidFertiliserDensityUoms());
        contents.setFertiliserDelutionRatioUoms(DefaultListFactory.getInstance().getDefaultFertiliserDilusionRatioUoms());
        contents.setAreaRoot(AreaFactory.getInstance().createAreaRoot());
        contents.setPlantsGroupRoot(PlantsFactory.getInstance().createPlantsGroupRoot());
        contents.setLogGroupRoot(LogFactory.getInstance().createLogGroupRoot());
        //      contentsValueWrapper.removePropertyChangeListeners();
        contentsValueWrapper.setValue(contents);
        //     selectedDataUnitValueWrapper.removePropertyChangeListeners();
        selectedDataUnitValueWrapper.setValue(contents.getAreaRoot());
        initGwiseProjectContents();
    }

    public boolean isValidProject(String path) {

        File file = new File(path);

        if (!file.isDirectory()) {
            return false;
        }

        ProjectConfiguration cf = new ProjectConfiguration(file.getName(), file.getParent(), null);
        File contentsFile = new File(cf.getJsonDataPath() + File.separator + PROJECT_CONTENTS_JSON_FILE);
        return contentsFile.isFile();
    }

    public boolean loadProject(String projectPath) {

        try {
            File file = new File(projectPath);

            File[] imageDirectories = new File(file.getAbsolutePath() + File.separator + "image").listFiles();

            configuration = new ProjectConfiguration(file.getName(), file.getParent(), getOpenImageDirectoryName(imageDirectories));

            File contentsFile = new File(configuration.getJsonDataPath() + File.separator + PROJECT_CONTENTS_JSON_FILE);

            if (contentsFile.isFile()) {
                contentsValueWrapper.setValue(mapper.readValue(contentsFile, ProjectContents.class));
                return true;
            }
            contentsValueWrapper.setValue(null);
            return false;
        } catch (IOException ex) {
            throw new CustomLevelErrorRuntimeExceiption("Failed to read files from " + projectPath, ex);
        }
    }

    private String getOpenImageDirectoryName(File[] existingDirectories) {

        if (existingDirectories != null) {

            for (File directory : existingDirectories) {

                String name = directory.getName();
                if (directory.isDirectory() && name.startsWith(IMAGE_DIRECTORY_PREFIX) && directory.list().length <= IMAGE_DIRECTORY_SIZE) {
                    return name;
                }
            }
        }

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        return IMAGE_DIRECTORY_PREFIX + format.format(date);
    }

    public void createProject(String parentPath, String name) {

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        String openImageDirectoryName = IMAGE_DIRECTORY_PREFIX + format.format(date);

        configuration = new ProjectConfiguration(name, parentPath, openImageDirectoryName);
        String path = configuration.getProjectPath();
        File file = new File(path);

        boolean success = file.mkdirs() && new File(configuration.getOpenImageDirectoryPath()).mkdirs();

        if (!success) {
            throw new CustomLevelErrorRuntimeExceiption("Failed to create folder: " + file.getAbsolutePath() + ".\n Make sure the location is clear or change to another location.");
        }
        try {
            properties.setProperty(CURRENT_RPOJECT_PATH_KEY, path);
            properties.setProperty(OPEN_IMAGE_DIRECTORY_NAME_KEY, openImageDirectoryName);
            saveProperties(properties, "");
            initContents();

            File contentsFile = new File(configuration.getJsonDataPath() + File.separator + "project_contents" + JSON_FILE_EXTENSION);
            contentsFile.getParentFile().mkdirs();
            contentsFile.createNewFile();
            mapper.writer().writeValue(contentsFile, contentsValueWrapper.getValue());

            FileUtils.copyDirectory(new File(SettingConstants.REPOSITORY_DATA_DIRECTORY), new File(configuration.getProjectPath() + File.separator + SettingConstants.RELATIVE_DATA_DIRECTORY));
        } catch (IOException ex) {
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
    }

    private void saveProperties(Properties properties, String comment) throws IOException {
        try (FileOutputStream out = new FileOutputStream(new File(SettingConstants.REPOSITORY_CONFIG_FILE_PATH));) {
            properties.store(out, comment);
        }
    }

    public ProjectConfiguration getConfiguration() {
        return configuration;
    }

    public ValueWrapper<ProjectContents> getContentsValueWrapper() {
        return contentsValueWrapper;
    }

    public ProjectContents getContents() {
        return contentsValueWrapper.getValue();
    }

    public ValueWrapper<GwiseProjectContents> getGwiseProjectContentsWrapper() {
        return gwiseProjectContentsWrapper;
    }

    public GwiseProjectContents getGwiseProjectContents() {
        return gwiseProjectContentsWrapper.getValue();
    }

    public void deleteProject(ProjectConfiguration configuration) {
        configuration = null;
    }

    public void saveItem(DataUnit item) throws IOException {

        mapper.writer().writeValue(new File(configuration.getJsonDataPath() + File.separator + item.getClass().getSimpleName() + FILE_NAME_SEPERATOR + item.getId() + JSON_FILE_EXTENSION), item);
    }

    public void saveProject() {
        try {

            File file = new File(configuration.getJsonDataPath() + File.separator + "project_contents" + JSON_FILE_EXTENSION);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            mapper.writer().writeValue(file, contentsValueWrapper.getValue());
        } catch (IOException ex) {
            throw new CustomLevelErrorRuntimeExceiption("Failed to save the project.", ex);
        }
    }

    public void exit() {
        Logger.getLogger(MainApp.class).info("The applicaiton is ended normally.\n\n\n\n");
        System.exit(0);
    }

    public void close() {
        contentsValueWrapper.setValue(null);
        configuration = null;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    public boolean hasListeners(String propertyName) {
        return propertyChangeSupport.hasListeners(propertyName);
    }

    public <T extends DataUnit> T getItem(int id) {
        return (T) dataMap.get(id);
    }

    public void addItem(DataUnit unit) {
        dataMap.put(unit.getId(), unit);
    }

    public void removeItem(DataUnit unit) {
        dataMap.remove(unit.getId(), unit);
    }

    public <T extends GwiseDataUnit> T getGwiseItem(int id) {
        return (T) gwiseDataMap.get(id);
    }

    public void addItem(GwiseDataUnit unit) {
        gwiseDataMap.put(unit.getId(), unit);
    }

    public void removeItem(GwiseDataUnit unit) {
        gwiseDataMap.remove(unit.getId(), unit);
    }

    public void deleteProject() {

        File file = new File(configuration.getProjectPath());
        close();
        boolean success = file.delete();

        if (!success) {
            throw new CustomLevelWarningRuntimeExceiption("Failed to delete " + file.getAbsolutePath());
        }
    }

    public ValueWrapper<DataUnit> getSelectedDataUnitValueWrapper() {
        return selectedDataUnitValueWrapper;
    }

    public ValueWrapper<GwiseDataUnit> getSelectedGwiseDataUnitValueWrapper() {
        return selectedGwiseDataUnitValueWrapper;
    }

    public List<SubareaLogoItem> getSubareaLogoItems() {
        return subareaLogoItems;
    }

    private List<SubareaLogoItem> loadSubareaLogoItems() {
        List<SubareaLogoItem> list = new ArrayList<>();
        try {
            File fXmlFile = new File("src/main/resources/config/subarea-logo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList logoNodeList = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < logoNodeList.getLength(); i++) {
                Node logoNode = logoNodeList.item(i);
                if (logoNode != null) {
                    NamedNodeMap attrs = logoNode.getAttributes();
                    if (attrs != null) {
                        for (GwiseSubAreaType subAreaType : GwiseSubAreaType.values()) {
                            for (GwiseShapeType shapeType : GwiseShapeType.values()) {

                                Attr typeAttr = (Attr) attrs.getNamedItem("type");
                                String typeAttrName = typeAttr == null ? "" : typeAttr.getValue();
                                Attr shapeAttr = ((Attr) attrs.getNamedItem("shape"));
                                String shapeAttrName = shapeAttr.getValue();
                                if (subAreaType.name().equals(typeAttrName) && shapeType.name().equals(shapeAttrName)) {
                                    list.add(new SubareaLogoItem(subAreaType, shapeType, ((Attr) logoNode.getAttributes().getNamedItem("type")).getValue()));
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new CustomLevelErrorRuntimeExceiption(ex);
        }
        return list;
    }

    private void initGwiseProjectContents() throws IOException {

        File file = new File("");
        
        GwiseProjectContentsBean p = file.isFile() ? mapper.readValue(file, GwiseProjectContentsBean.class) : null;
  //      RepositoryManager.getInstance().loadDefaultData(DEFAULT_DATA_DIRECTORY + File.separator + GrowingMediumGroup.class
  //              .getSimpleName() + SettingConstants.JSON_FILE_EXTENSION, GwiseProjectContents.class);

        if (p == null) {
            p = new GwiseProjectContentsBean();
            try {

                File fXmlFile = new File("src/main/resources/config/contents-en.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                NodeList n1List = doc.getDocumentElement().getChildNodes();
                for (int i = 0; i < n1List.getLength(); i++) {
                    Node n1 = n1List.item(i);
                    String n1Name = n1.getNodeName();
                    if (null != n1Name) {
                        switch (n1Name) {
                            case "area-root":
                                GwiseAreaRootBean areaRootBean = new GwiseAreaRootBean();
                                p.setAreaRoot(areaRootBean);
                                areaRootBean.setAreas(new ArrayList<GwiseAreaBean>());
                                NodeList n2List = n1.getChildNodes();
                                for (int j = 0; j < n2List.getLength(); j++) {

                                    Node n2 = n2List.item(j);
                                    String n2Name = n2.getNodeName();
                                    if (n2Name != null && n2Name.equals("area")) {
                                        GwiseGardenAreaBean gardenAreaBean = new GwiseGardenAreaBean();
                                        areaRootBean.getAreas().add(gardenAreaBean);
                                        NodeList n3List = n2.getChildNodes();
                                        for (int k = 0; k < n3List.getLength(); k++) {
                                            Node n3 = n3List.item(k);
                                            String n3Name = n3.getNodeName();

                                            if (n3Name != null && n3Name.equals("subarea")) {
                                                GwisePlantBedBean plantBedBean = new GwisePlantBedBean();
                                                gardenAreaBean.getPlantBeds().add(plantBedBean);
                                            }

                                        }
                                    }
                                }

                                break;

                            case "plant-group-root":
                                GwisePlantGroupRootBean plantGroupRootBean = new GwisePlantGroupRootBean();
                                p.setPlantGroupRoot(plantGroupRootBean);
                                plantGroupRootBean.setPlantGroups(new ArrayList<GwisePlantGroupBean>());
                                NodeList n3List = n1.getChildNodes();
                                for (int j = 0; j < n3List.getLength(); j++) {

                                    Node plantGroupNode = n3List.item(j);
                                    String n3Name = plantGroupNode.getNodeName();
                                    if (n3Name != null && n3Name.equals("area")) {
                                        GwisePlantGroupBean plantGroup = new GwisePlantGroupBean();
                                        plantGroup.setPlantTypeBeans(new ArrayList<PlantTypeBean>());
                                        plantGroupRootBean.getPlantGroups().add(plantGroup);
                                        NodeList plantTypeNodeList = plantGroupNode.getChildNodes();
                                        for (int k = 0; k < plantTypeNodeList.getLength(); k++) {
                                            Node plantTypeNode = plantTypeNodeList.item(k);
                                            String plantTypeNodeName = plantTypeNode.getNodeName();

                                            if (plantTypeNodeName != null && plantTypeNodeName.equals("plant-type")) {
                                                PlantTypeBean plantTypeBean = new PlantTypeBean();
                                                plantGroup.getPlantTypeBeans().add(plantTypeBean);

                                                NodeList plantVarietiesNodeList = plantTypeNode.getChildNodes();
                                                for (int l = 0; l < plantVarietiesNodeList.getLength(); l++) {
                                                    Node plantVarietyNode = plantVarietiesNodeList.item(l);
                                                    String plantVarietyNodeName = plantVarietyNode.getNodeName();
                                                    if (plantVarietyNodeName != null && plantVarietyNodeName.equals("plant-variety")) {
                                                        GwisePlantVarietyBean plantVarietyBean = new GwisePlantVarietyBean();
                                                        plantVarietyBean.setTitle(((Attr) plantVarietyNode.getAttributes().getNamedItem("title")).getValue());
                                                        plantVarietyBean.setLogoPath(((Attr) plantVarietyNode.getAttributes().getNamedItem("logo")).getValue());
                                                    }
                                                }

                                            }

                                        }
                                    }
                                }
                                break;
                            case "log-group-root":
                                GwiseLogGroupRootBean logGroupRootBean = new GwiseLogGroupRootBean();
                                p.setLogGroupRoot(logGroupRootBean);
                                break;
                            case "growing-medium":
                                GwiseGrowingMediumBean bean = new GwiseGrowingMediumBean();
                                p.getGrowingMediums().add(bean);
                                break;

                            default:
                        }
                    }

                }

            } catch (ParserConfigurationException | SAXException ex) {
                throw new CustomLevelErrorRuntimeExceiption(ex);
            }
        }
        gwiseProjectContentsWrapper.setValue(new GwiseProjectContents(p));
    }
}
