package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.gwise.data.ValueWrapper;
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