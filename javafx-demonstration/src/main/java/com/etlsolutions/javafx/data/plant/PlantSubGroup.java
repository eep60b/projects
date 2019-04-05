package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 * The PlantType class represents a group of plant with a distinguished plant
 * type which is loosely related but not restricted to the plant species. The plant species
 * is not restrictively used by shops and gardeners. Examples: Strawberry,
 * Squash, Bean, Pea etc.
 *
 * The title of plant sub group must be unique. And it con only belong to a single group.
 * 
 * @author zc
 */
public class PlantSubGroup extends DataUnit {

    private int plantGroupId;
    private ObservableListWrapperA<Plants> plants;

    //This property will not be shown in the tree.  
    private ObservableListWrapperA<PlantVariety> plantVarieties;

    public PlantSubGroup() {
    }

    public PlantSubGroup(PlantSubGroupValueWrapper valueWrapper) {
        super(valueWrapper);
        this.plantGroupId = valueWrapper.getPlantGroupValueWrapper().getValue().getId();
        this.plants = new ObservableListWrapperA<>(valueWrapper.getPlants());
        this.plantVarieties = new ObservableListWrapperA<>(valueWrapper.getPlantVarieties());
    }

    public int getPlantGroupId() {
        return plantGroupId;
    }

    public void setPlantGroupId(int plantGroupId) {
        this.plantGroupId = plantGroupId;
    }

    public ObservableListWrapperA<Plants> getPlants() {
        return plants;
    }

    public void setPlants(ObservableListWrapperA<Plants> plants) {
        this.plants = plants;
    }

    public ObservableListWrapperA<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    public void setPlantVarieties(ObservableListWrapperA<PlantVariety> plantVarieties) {
        this.plantVarieties = plantVarieties;
    }

    public void setValues(PlantSubGroupValueWrapper valueWrapper) {

        setCommonValues(valueWrapper);
        plantVarieties = new ObservableListWrapperA<>(valueWrapper.getPlantVarieties());
        plants = new ObservableListWrapperA<>(valueWrapper.getPlants());
    }
}
