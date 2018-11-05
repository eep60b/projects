package com.etlsolutions.javafx.system;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.area.AreaRoot;
import com.etlsolutions.javafx.data.log.LogGroupRoot;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.plant.PlantGroupRoot;
import javafx.collections.ObservableList;

/**
 * The ProjectConfiguration class contains all the information about a project to run the application.
 *
 * @author zc
 */
public class ProjectContents {
    
    private AreaRoot areaRoot;
    private PlantGroupRoot plantsGroupRoot;
    private LogGroupRoot logGroupRoot;
    private ObservableListWrapperA<GrowingMedium> growingMediums;
    private ObservableListWrapperA<Fertiliser> fertilisers;
    
    private ObservableListWrapperA<String> locationReferencePoints;
    private ObservableListWrapperA<String> locationDirections;
    private ObservableListWrapperA<String> containerShapes;
    private ObservableListWrapperA<String> flowerTypes;
    private ObservableListWrapperA<String> flowerColors;
    private ObservableListWrapperA<String> fruitShapes;
    private ObservableListWrapperA<String> fruitColors;
    private ObservableListWrapperA<String> fertiliserUoms;
    
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

    public ObservableListWrapperA<Fertiliser> getFertilisers() {
        return fertilisers;
    }

    public void setFertilisers(ObservableListWrapperA<Fertiliser> fertilisers) {
        this.fertilisers = fertilisers;
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

    public ObservableListWrapperA<String> getFlowerTypes() {
        return flowerTypes;
    }

    public void setFlowerTypes(ObservableListWrapperA<String> flowerTypes) {
        this.flowerTypes = flowerTypes;
    }   

    public ObservableListWrapperA<String> getFlowerColors() {
        return flowerColors;
    }

    public void setFlowerColors(ObservableListWrapperA<String> flowerColors) {
        this.flowerColors = flowerColors;
    }

    public ObservableListWrapperA<String> getFruitShapes() {
        return fruitShapes;
    }

    public void setFruitShapes(ObservableListWrapperA<String> fruitShapes) {
        this.fruitShapes = fruitShapes;
    }

    public ObservableListWrapperA<String> getFruitColors() {
        return fruitColors;
    }

    public void setFruitColors(ObservableListWrapperA<String> fruitColors) {
        this.fruitColors = fruitColors;
    }

    public ObservableListWrapperA<String> getFertiliserUoms() {
        return fertiliserUoms;
    }

    public void setFertiliserUoms(ObservableListWrapperA<String> fertiliserUoms) {
        this.fertiliserUoms = fertiliserUoms;
    }
    
    
}