package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class CreateVarietyDataModel extends AbstractVarietyDataModel {
    
    @Override
    public void save() {
        variety = PlantsFactory.getInstance().createPlantVariety(getTitle(), getLatinName(), getInformation(), getAliases(), getImageLinks());
    }
}