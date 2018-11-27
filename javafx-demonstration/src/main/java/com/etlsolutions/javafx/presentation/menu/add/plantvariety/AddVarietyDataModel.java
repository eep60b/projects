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
        dataUnit = PlantsFactory.getInstance().createPlantVariety(getTitleValueWrapper(), getLatinName(), getInformationValueWrapper(), getAliases(), getImageLinks());
        plantType.getPlantVarieties().add(dataUnit);
    }
}