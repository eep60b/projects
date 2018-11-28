package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;

/**
 *
 * @author zc
 */
public class EditGrowingMediumDataModel extends AbstractGrowingMediumDataModel {

    public EditGrowingMediumDataModel(GrowingMedium growingMedium) {
        super(growingMedium);
    }

    @Override
    public void save() {
        
        get().setValues(commonValueWrapper, specialValueWrapper);
    }
}
