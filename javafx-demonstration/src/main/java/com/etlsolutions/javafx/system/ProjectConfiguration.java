package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantsGroupRoot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
    private boolean encrypted;
    private AreaRoot areaRoot;
    private PlantsGroupRoot plantsGroupRoot;
    private LogGroupRoot logRoot;

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

    public AreaRoot getAreaRoot() {
        return areaRoot;
    }

    public void setAreaRoot(AreaRoot areaRoot) {
        this.areaRoot = areaRoot;
    }

    public PlantsGroupRoot getPlantsGroupRoot() {
        return plantsGroupRoot;
    }

    public void setPlantsGroupRoot(PlantsGroupRoot plantsGroupRoot) {
        this.plantsGroupRoot = plantsGroupRoot;
    }

    public LogGroupRoot getLogRoot() {
        return logRoot;
    }

    public void setLogRoot(LogGroupRoot logRoot) {
        this.logRoot = logRoot;
    }    
}
