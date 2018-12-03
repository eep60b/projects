package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddVarietyDataModel extends AbstractVarietyDataModel {
    
    private final PlantSubGroup plantSubGroup;

    public AddVarietyDataModel(PlantSubGroup plantType) {
        this.plantSubGroup = plantType;
    }

    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantVariety(commonValueWrapper, plantSubGroup.getId(), getLatinNameValueWrapper().getValue(), aliases));
        plantSubGroup.getPlantVarieties().add(get());
    }
}