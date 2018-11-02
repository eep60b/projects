package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.other.GrowingFertiliser;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import javafx.collections.ObservableList;

/**
 * The ProjectConfiguration class contains all the information about a project to run the application.
 *
 * @author zc
 */
public class ProjectConfiguration {

    @JsonIgnore
    private String name;
    @JsonIgnore
    private String parentPath;
    @JsonIgnore    
    private boolean encrypted;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public boolean isPasswordProtected() {
        return encrypted;
    }

    public void setPasswordProtected(boolean passwordProtected) {
        this.encrypted = passwordProtected;
    }

    public String getProjectPath() {
        return parentPath + File.separator + name;
    }

    public String getJsonDataPath() {
        return getProjectPath() + File.separator + "data" + File.separator + "json";
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }
}
