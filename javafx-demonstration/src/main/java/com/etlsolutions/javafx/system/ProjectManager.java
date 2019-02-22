package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.MainApp;
import static com.etlsolutions.javafx.system.SettingConstants.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ValueWrapper;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

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
    private final ValueWrapper<ProjectContents> contentsValueWrapper = new ValueWrapper<>(null);
    private final Map<Integer, DataUnit> dataMap = new HashMap<>();
    private final Properties properties = GwiseRepository.getInstance().getProperties();
    private final ValueWrapper<DataUnit> selectedDataUnit = new ValueWrapper<>(null);

    private ProjectManager() {
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
        contentsValueWrapper.removePropertyChangeListeners();
        contentsValueWrapper.setValue(contents);
        selectedDataUnit.removePropertyChangeListeners();
        selectedDataUnit.setValue(contents.getAreaRoot());
    }

    public boolean isValidProject(String path) {

        File file = new File(path);

        if (!file.isDirectory()) {
            return false;
        }

        ProjectConfiguration cf = new ProjectConfiguration(file.getName(), file.getParent(), null);
        File contentsFile = new File(cf.getJsonDataPath() + File.separator + PROJECT_CONTENTS_JSON_FILE_EXTENSION);
        return contentsFile.isFile();
    }

    public boolean loadProject(String projectPath) {

        try {
            File file = new File(projectPath);

            File[] imageDirectories = new File(file.getAbsolutePath() + File.separator + "image").listFiles();

            configuration = new ProjectConfiguration(file.getName(), file.getParent(), getOpenImageDirectoryName(imageDirectories));

            File contentsFile = new File(configuration.getJsonDataPath() + File.separator + PROJECT_CONTENTS_JSON_FILE_EXTENSION);

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

    public void deleteProject() {

        File file = new File(configuration.getProjectPath());
        close();
        boolean success = file.delete();

        if (!success) {
            throw new CustomLevelWarningRuntimeExceiption("Failed to delete " + file.getAbsolutePath());
        }
    }

    public ValueWrapper<DataUnit> getSelectedDataUnitValueWrapper() {
        return selectedDataUnit;
    }
}
