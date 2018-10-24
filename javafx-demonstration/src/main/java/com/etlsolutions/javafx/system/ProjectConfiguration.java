package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.data.GrowingMedium;
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
    
    private boolean encrypted;
    private AreaRoot areaRoot;
    private PlantGroupRoot plantsGroupRoot;
    private LogGroupRoot logGroupRoot;
    private ObservableListWrapperA<GrowingMedium> growingMediums;
    private ObservableListWrapperA<String> locationReferencePoints;
    private ObservableListWrapperA<String> locationDirections;
    private ObservableListWrapperA<String> containerShapes;
    
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

    public PlantGroupRoot getPlantsGroupRoot() {
        return plantsGroupRoot;
    }

    public void setPlantsGroupRoot(PlantGroupRoot plantsGroupRoot) {
        this.plantsGroupRoot = plantsGroupRoot;
    }

    public LogGroupRoot getLogGroupRoot() {
        return logGroupRoot;
    }

    public void setLogGroupRoot(LogGroupRoot logGroupRoot) {
        this.logGroupRoot = logGroupRoot;
    }    

    public boolean isModified() {
        return false;
    }

    public ObservableList<GrowingMedium> getGrowingMediums() {
        return growingMediums;
    }

    public void setGrowingMediums(ObservableListWrapperA<GrowingMedium> growingMediums) {
        this.growingMediums = growingMediums;
    }

    public ObservableListWrapperA<String> getLocationReferencePoints() {
        return locationReferencePoints;
    }

    public void setLocationReferencePoints(ObservableListWrapperA<String> locationReferencePoints) {
        this.locationReferencePoints = locationReferencePoints;
    }

    public ObservableListWrapperA<String> getLocationDirections() {
        return locationDirections;
    }

    public void setLocationDirections(ObservableListWrapperA<String> locationDirections) {
        this.locationDirections = locationDirections;
    } 

    public ObservableListWrapperA<String> getContainerShapes() {
        return containerShapes;
    }

    public void setContainerShapes(ObservableListWrapperA<String> containerShapes) {
        this.containerShapes = containerShapes;
    }
}
