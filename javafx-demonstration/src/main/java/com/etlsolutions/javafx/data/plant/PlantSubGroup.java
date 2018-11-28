package com.etlsolutions.javafx.data.plant;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 * The PlantType class represents a plant type which loosely corresponding to
 the plant species. As the plant species is not restrictively used by shops
 * and gardeners, Examples: Strawberry, Squash, Bean, Pea etc.
 *
 * @author zc
 */
public class PlantSubGroup extends DataUnit {
    
    private int plantGroupId;
    private ObservableListWrapperA<Plants> plantsList;

    //This property will not be shown in the tree.  
    private ObservableListWrapperA<PlantVariety> plantVarieties;
    
    public PlantSubGroup() {
    }

    public PlantSubGroup(DataUnitValueWrapper valueWrapper, int plantGroupId, ObservableListWrapperA<Plants> plantsList, ObservableListWrapperA<PlantVariety> plantVarieties) {
        super(valueWrapper);
        this.plantGroupId = plantGroupId;
        this.plantsList = plantsList;
        this.plantVarieties = plantVarieties;
    }
    
    public int getPlantGroupId() {
        return plantGroupId;
    }

    public void setPlantGroupId(int plantGroupId) {
        this.plantGroupId = plantGroupId;
    }

    public ObservableListWrapperA<Plants> getPlantsList() {
        return plantsList;
    }

    public void setPlantsList(ObservableListWrapperA<Plants> plantsList) {
        this.plantsList = plantsList;
    }

    public ObservableListWrapperA<PlantVariety> getPlantVarieties() {
        return plantVarieties;
    }

    public void setPlantVarieties(ObservableListWrapperA<PlantVariety> plantVarieties) {
        this.plantVarieties = plantVarieties;
    }   
}
