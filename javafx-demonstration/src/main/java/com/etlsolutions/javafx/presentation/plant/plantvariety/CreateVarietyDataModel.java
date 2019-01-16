package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantsFactory;

/**
 *
 * @author zc
 */
public class CreateVarietyDataModel extends AbstractVarietyDataModel {

    public CreateVarietyDataModel() {
        super(null, new ValueWrapper<>(""));
    }
   
    @Override
    public void save() {
        set(PlantsFactory.getInstance().createPlantVariety(getValueWrapper()));
    }
}