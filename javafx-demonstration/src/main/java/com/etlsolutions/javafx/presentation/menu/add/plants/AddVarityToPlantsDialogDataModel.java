package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyAddable;

/**
 *
 * @author zc
 */
public class AddVarityToPlantsDialogDataModel implements VarietyAddable {

    private final AddPlantsDataModel model;

    public AddVarityToPlantsDialogDataModel(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public boolean addVariety(PlantVariety variety) {
        return model.addPlantVariety(variety);
    }  
}
