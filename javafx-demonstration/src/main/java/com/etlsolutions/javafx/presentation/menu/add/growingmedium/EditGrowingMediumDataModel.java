package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;

/**
 *
 * @author zc
 */
public class EditGrowingMediumDataModel extends AbstractGrowingMediumDataModel {

    public EditGrowingMediumDataModel(GrowingMedium growingMedium) {
        super(growingMedium);
        this.dataUnit = growingMedium;
    }

    @Override
    public void save() {
        dataUnit.setValues(commonValueWrapper, specialValueWrapper);
    }
}
