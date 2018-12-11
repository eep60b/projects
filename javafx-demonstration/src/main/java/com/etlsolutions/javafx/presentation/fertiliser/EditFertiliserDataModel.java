package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserValueWrapper;

/**
 *
 * @author zc
 */
public class EditFertiliserDataModel  extends AbstractFertiliserDataModel {

    public EditFertiliserDataModel(Fertiliser fertiliser) {
        super(fertiliser, new FertiliserValueWrapper(fertiliser), fertiliser.type());
    }

    @Override
    public void save() {
        Fertiliser dataUnit = get();
        dataUnit.setCommonValues(commonValueWrapper);
        dataUnit.setAluminium(Double.parseDouble(valueWrapper.getAluminium().getValue()));
    }
}
