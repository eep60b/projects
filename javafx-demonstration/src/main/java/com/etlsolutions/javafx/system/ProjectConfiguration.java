package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.data.plant.PlantsGroupRoot;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;

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
    private LogGroupRoot logGroupRoot;
        
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

    public LogGroupRoot getLogGroupRoot() {
        return logGroupRoot;
    }

    public void setLogGroupRoot(LogGroupRoot logGroupRoot) {
        this.logGroupRoot = logGroupRoot;
    }    

    public boolean isModified() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
