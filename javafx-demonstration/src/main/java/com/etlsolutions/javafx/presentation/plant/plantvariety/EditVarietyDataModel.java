package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.plant.PlantVariety;

/**
 *
 * @author zc
 */
public class EditVarietyDataModel extends AbstractVarietyDataModel {

    public EditVarietyDataModel(PlantVariety variety) {
        super(variety);
    }

    @Override
    public void save() {
        get().setCommonValues(commonValueWrapper);
        get().setLatinName(latinNameValueWrapper.getValue());
        get().setAliases(aliases);
    }
}
