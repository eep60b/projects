package com.etlsolutions.javafx.system;

import static com.etlsolutions.javafx.system.SettingConstants.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.GrowingMediumFactory;
import com.etlsolutions.javafx.data.GrowingMediumGroup;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Properties;
import javax.imageio.IIOException;

/**
 * ProjectManager ONLY manage the currently-opened project.
 *
 * @author zc
 */
public final class ProjectManager {

    public static final String NEW_PROJECT_PROPERTY = "com.etlsolutions.javafx.system.ProjectManager.NEW_PROJECT_PROPERTY";

    private static final ProjectManager INSTANCE = new ProjectManager();

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private final ObjectMapper mapper = new ObjectMapper();
    private ProjectConfiguration configuration;

    private ProjectManager() {
    }

    public static ProjectManager getInstance() {
        return INSTANCE;
    }

    void init(Properties properties) throws IOException {

        configuration = new ProjectConfiguration();
        String path = properties.getProperty(CURRENT_RPOJECT_PATH_KEY);
        if (path != null) {
            File directory = new File(path);
            if (directory.isDirectory()) {
                loadProject(path);
                return;
            }

            if (directory.isFile()) {
                throw new IIOException("The specified path is already used by a file.");
            }

            File projectDirectory = new File(path);

            if (!projectDirectory.mkdirs()) {
                throw new IIOException("Failed to create directory.");
            }

            configuration.setParentPath(projectDirectory.getParent());
            configuration.setName(projectDirectory.getName());
            configuration.setGrowingMediums(GrowingMediumFactory.getInstance().createDefaultGrowingMediums());
        } else {
            //      createProject(projectDirectory.getParent(), projectDirectory.getName());

            //manually set things up for now.
            configuration.setGrowingMediums(RepositoryManager.getInstance().loadDefaultData(DEFAULT_DATA_DIRECTORY + File.separator + GrowingMediumGroup.class.getSimpleName() + SettingConstants.JSON_FILE_EXTENSION, GrowingMediumGroup.class).getGrowingMediums());
        }

        configuration.setAreaRoot(AreaFactory.createAreaRoot());
        configuration.setPlantsGroupRoot(PlantsFactory.createPlantsGroupRoot());
        configuration.setLogGroupRoot(LogFactory.createLogGroupRoot());
    }

    public ProjectConfiguration loadProject(String projectPath) throws IOException {

        File file = new File(projectPath);
        configuration.setParentPath(file.getParent());
        configuration.setName(file.getName());
        File jsonDataDir = new File(configuration.getJsonDataPath());
        List<File> jsonFiles = new ArrayList<>();

        for (File child : file.listFiles()) {
            if (child.getName().endsWith(JSON_FILE_EXTENSION)) {

            }
        }

        return configuration;
    }

    public ProjectConfiguration createProject(String parentPath, String name) {

        configuration = new ProjectConfiguration();
        configuration.setParentPath(parentPath);
        configuration.setName(name);
        configuration.setGrowingMediums(GrowingMediumFactory.getInstance().createDefaultGrowingMediums());
        File file = new File(configuration.getProjectPath());
        boolean success = file.mkdirs();

        if (!success) {
            throw new CustomLevelErrorRuntimeExceiption("Failed to create folder: " + file.getAbsolutePath() + ".\n Make sure the location is clear or change to another location.");
        }

        propertyChangeSupport.firePropertyChange(NEW_PROJECT_PROPERTY, false, true);

        return configuration;
    }

    public ProjectConfiguration getProject() {
        return configuration;
    }

    public void deleteProject(ProjectConfiguration configuration) {
        configuration = null;
    }

    public void saveItem(DataUnit item) throws IOException {

        mapper.writer().writeValue(new File(configuration.getJsonDataPath() + File.separator + item.getClass().getSimpleName() + FILE_NAME_SEPERATOR + item.getId() + JSON_FILE_EXTENSION), item);
    }

    public void saveProject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
