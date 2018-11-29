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

    public AddVarietyDataModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantVariety(commonValueWrapper, plantSubGroup.getId(), errorMessage, aliases));
        plantSubGroup.getPlantVarieties().add(get());
    }
}