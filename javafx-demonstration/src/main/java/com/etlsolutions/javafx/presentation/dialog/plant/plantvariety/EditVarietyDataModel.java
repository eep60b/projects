package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantVarietyValueWrapper;

/**
 *
 * @author zc
 */
public class EditVarietyDataModel extends AbstractVarietyDataModel {

    public EditVarietyDataModel(PlantVariety variety) {
        super(new PlantVarietyValueWrapper(variety),  new ValueWrapper<>(variety.getAliases().isEmpty() ? "" : variety.getAliases().get(0)));
    }

    @Override
    public void save() {
        getItem().setValues(getValueWrapper());
    }
}
