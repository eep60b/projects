package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddVarietyDataModel extends AbstractVarietyDataModel {
    
    private final PlantSubGroup plantType;

    public AddVarietyDataModel(PlantSubGroup plantType) {
        this.plantType = plantType;
    }
    
    @Override
    public void save() {
        item = PlantsFactory.getInstance().createPlantVariety(getTitle(), getLatinName(), getInformation(), getAliases(), getImageLinks());
        plantType.getPlantVarieties().add(item);
    }
}