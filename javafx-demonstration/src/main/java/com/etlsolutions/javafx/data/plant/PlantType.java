package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The PlantType class represents a plant type which loosely corresponding to
 the plant species. As the plant species is not restrictively used by shops
 * and gardeners, Examples: Strawberry, Squash, Bean, Pea etc.
 *
 * @author zc
 */
public class PlantType extends DataUnit {

    @JsonIgnore
    public static final String GROUP_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantType.GROUP_PROPERTY";
    
    private PlantGroup group;
    private ObservableList<Plants> plantsList;
    
    
    //This property will not be shown in the tree.    
    private ObservableList<PlantVariety> plantVarieties;

    public PlantType() {
    }
    
    PlantType(String title, String information) {
        super(title, information);
        this.plantVarieties = FXCollections.observableArrayList();
        this.plantsList = FXCollections.observableArrayList();
    }

    public PlantType(String title, String information, ObservableList<ImageLink> imageLinks, ObservableList<PlantVariety> plantVarieties) {
        super(title, information, imageLinks, 0, null);
        this.plantVarieties = plantVarieties;
        this.plantsList = FXCollections.observableArrayList();        
    }
         
    public ObservableList<Plants> getPlantsList() {
        return plantsList;
    }

    public ObservableList<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    
    public PlantGroup getGroup() {
        return group;
    }

    public void setGroup(PlantGroup group) {
        PlantGroup oldValue = this.group;
        this.group = group;
        fireChange(GROUP_PROPERTY, oldValue, this.group);
    }
   
}
