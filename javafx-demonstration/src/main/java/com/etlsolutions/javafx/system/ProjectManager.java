package com.etlsolutions.javafx.system;

import static com.etlsolutions.javafx.system.SettingConstants.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.plant.PlantsFactory;
import java.util.Properties;
import javax.imageio.IIOException;

/**
 * ProjectManager ONLY manage the currently-opened project.
 *
 * @author zc
 */
public final class ProjectManager {

    private static final ProjectManager INSTANCE = new ProjectManager();

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
        }
        configuration.setAreaRoot(AreaFactory.createAreaRoot());
        configuration.setPlantsGroupRoot(PlantsFactory.createPlantsGroupRoot());
        configuration.setLogGroupRoot(LogFactory.createLogGroupRoot());
    }

    public ProjectConfiguration createPorject(String parentPath, String projectName) {

        configuration.setParentPath(parentPath);
        configuration.setName(projectName);

        return configuration;
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

    public ProjectConfiguration createProject(String parentPath, String name) throws IOException {

        configuration = new ProjectConfiguration();
        configuration.setParentPath(parentPath);
        configuration.setName(name);
        File file = new File(configuration.getProjectPath());
        boolean success = file.mkdirs();

        if (!success) {
            throw new IOException("Failed to create folder: " + file.getAbsolutePath() + ".\n Make sure the location is clear or change to another location.");
        }

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

}
