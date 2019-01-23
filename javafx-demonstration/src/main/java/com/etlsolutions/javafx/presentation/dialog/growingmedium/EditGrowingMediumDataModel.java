package com.etlsolutions.javafx.presentation.dialog.growingmedium;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.other.GrowingMediumSpecialValueWrapper;

/**
 *
 * @author zc
 */
public class EditGrowingMediumDataModel extends AbstractGrowingMediumDataModel {

    public EditGrowingMediumDataModel(GrowingMedium growingMedium) {
        super(new GrowingMediumSpecialValueWrapper(growingMedium));
        set(growingMedium);
    }

    @Override
    public void save() {        
        get().setValues(getValueWrapper());
    }
}
