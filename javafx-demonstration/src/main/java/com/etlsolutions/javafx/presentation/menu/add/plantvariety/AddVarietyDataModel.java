package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddVarietyDataModel extends AbstractVarietyDataModel {
    
    private final PlantType plantType;

    public AddVarietyDataModel(PlantType plantType) {
        this.plantType = plantType;
    }
    
    @Override
    public void save() {
        variety = PlantsFactory.getInstance().createPlantVariety(getTitle(), getLatinName(), getInformation(), getAliases(), getImageLinks());
        plantType.getPlantVarieties().add(variety);
    }
}