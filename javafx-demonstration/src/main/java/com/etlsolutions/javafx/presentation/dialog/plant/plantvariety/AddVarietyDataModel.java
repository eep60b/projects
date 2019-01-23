package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class AddVarietyDataModel extends AbstractVarietyDataModel {
    
    private final PlantSubGroup plantSubGroup;

    public AddVarietyDataModel(PlantSubGroup plantSubGroup) {
        super(PlantsFactory.getInstance().createDefaultPlantVarietyValueWrapper(plantSubGroup), new ValueWrapper<>(""));
        this.plantSubGroup = plantSubGroup;
    }

    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantVariety(getValueWrapper()));
        plantSubGroup.getPlantVarieties().add(get());
    }
}