package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class CreateVarietyDataModel extends AbstractVarietyDataModel {
    
    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantVariety(commonValueWrapper, 0, getLatinNameValueWrapper().getValue(), aliases));
    }
}