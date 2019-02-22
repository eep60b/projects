package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * The ProjectConfiguration class contains all the information about a project to run the application.
 *
 * @author zc
 */
public class ProjectConfiguration {

    private String name;
    private String parentPath;
    private String openImageDirectoryName;
    private final ValueWrapper<Boolean> modified = new ValueWrapper<>(true);
    private final ValueWrapper<Boolean> encrypted = new ValueWrapper<>(true);

    public ProjectConfiguration(String name, String parentPath, String openImageDirectoryName) {
        this.name = name;
        this.parentPath = parentPath;
        this.openImageDirectoryName = openImageDirectoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        modified.setValue(true);
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
        modified.setValue(true);        
    }

    public String getOpenImageDirectoryName() {
        return openImageDirectoryName;
    }

    public void setOpenImageDirectoryName(String openImageDirectoryName) {
        this.openImageDirectoryName = openImageDirectoryName;
    }
       
    private void generateNewOpenImageDirectoryName() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        
        openImageDirectoryName = SettingConstants.IMAGE_DIRECTORY_PREFIX + format.format(date);
    }
    
    public ValueWrapper<Boolean> getModified() {
        return modified;
    }

    public ValueWrapper<Boolean> getEncrypted() {
        return encrypted;
    }


    public String getProjectPath() {
        
        if(parentPath == null || parentPath.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            return null;
        }
        
        return parentPath + File.separator + name;
    }

    public String getJsonDataPath() {
        
        String projectPath = getProjectPath();
        return projectPath == null ? null : getProjectPath() + File.separator + "data" + File.separator + "json";
    }
    
    public String getOpenImageDirectoryPath() {
        
        String projectPath = getProjectPath();
        
        if(new File(getProjectPath() + File.separator + "image" + File.separator + openImageDirectoryName).list().length >= SettingConstants.IMAGE_DIRECTORY_SIZE) {
            generateNewOpenImageDirectoryName();
        }
        
        return projectPath == null ? null : getProjectPath() + File.separator + "image" + File.separator + openImageDirectoryName;        
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.parentPath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectConfiguration other = (ProjectConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.parentPath, other.parentPath);
    }
}
