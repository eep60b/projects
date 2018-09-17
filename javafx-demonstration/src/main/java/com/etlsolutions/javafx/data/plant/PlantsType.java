package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 * The PlantsType class represents a plant type which loosely corresponding to
 * the plant species. As the plant species is not restrictively used by shops
 * and gardeners, Examples: Strawberry, Squash, Bean, Pea etc.
 *
 * @author zc
 */
public class PlantsType extends DataUnit {

    @JsonIgnore
    public static final String GROUP_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsType.GROUP_PROPERTY";
    
    
    @JsonIgnore
    public static final String PLANTS_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsType.PLANTS_PROPERTY";
    
    @JsonIgnore
    public static final String VARIETIES_PROPERTY = "com.etlsolutions.javafx.data.plant.PlantsType.VARIETIES_PROPERTY";  
    
    private PlantGroup group;
    private List<Plants> plantsList;
    
    
    //This property will not be shown in the tree.    
    private List<PlantVariety> plantVarieties;

    public PlantsType() {
    }
    
    PlantsType(String title, String information, List<PlantVariety> varieties, List<ImageLink> imageLinks, List<Plants> plantsList) {
        super(title, information, imageLinks);
        this.plantVarieties = varieties;
        this.plantsList = plantsList;
    }

    public PlantGroup getGroup() {
        return group;
    }

    public void setGroup(PlantGroup group) {
        PlantGroup oldValue = this.group;
        this.group = group;
        fireChange(GROUP_PROPERTY, oldValue, this.group);
    }
    
    public List<Plants> getPlantses() {
        return new ArrayList<>(plantsList);
    }

    public void setPlantsList(List<Plants> plantsList) {
        this.plantsList = new ArrayList<>(plantsList);
        fireChange(PLANTS_PROPERTY);
    }

    public boolean addPlants(Plants plants) {
        boolean added = plantsList.add(plants);
        fireChange(PLANTS_PROPERTY, false, added);
        return added;
    }

    public boolean removePlants(Plants plants) {
        boolean removed = plantsList.add(plants);
        fireChange(PLANTS_PROPERTY, false, removed);
        return removed;
    }

    public List<PlantVariety> getPlantVarieties() {
        return new ArrayList<>(plantVarieties);
    }

    public void setPlantVarieties(List<PlantVariety> plantVarieties) {
        this.plantVarieties = new ArrayList<>(plantVarieties);
        fireChange(VARIETIES_PROPERTY);        
    }
    
    public boolean addPlantVariety(PlantVariety plantVariety) {
        boolean added = plantVarieties.add(plantVariety);
        fireChange(VARIETIES_PROPERTY, false, added);        
        return added;
    }   
    
    public boolean removePlantVariety(PlantVariety plantVariety) {
        boolean removed = plantVarieties.remove(plantVariety);
        fireChange(VARIETIES_PROPERTY, false, removed);        
        return removed;
    }     
}
