package com.etlsolutions.javafx.presentation.dialog.fertiliser;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserValueWrapper;

/**
 *
 * @author zc
 */
public class EditFertiliserDataModel  extends AbstractFertiliserDataModel {

    public EditFertiliserDataModel(Fertiliser fertiliser) {
        super(fertiliser, new FertiliserValueWrapper(fertiliser), fertiliser.getType());
    }

    @Override
    public void save() {
        Fertiliser dataUnit = getItem();
        dataUnit.setCommonValues(getValueWrapper());
        dataUnit.setAluminium(Double.parseDouble(valueWrapper.getAluminium().getValue()));
    }
}
