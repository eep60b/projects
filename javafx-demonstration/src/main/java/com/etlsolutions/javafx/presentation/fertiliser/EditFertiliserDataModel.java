package com.etlsolutions.javafx.presentation.fertiliser;

import com.etlsolutions.javafx.data.other.Fertiliser;
import com.etlsolutions.javafx.data.other.FertiliserValueWrapper;

/**
 *
 * @author zc
 */
public class EditFertiliserDataModel  extends AbstractFertiliserDataModel {

    public EditFertiliserDataModel(Fertiliser fertiliser) {
        super(new FertiliserValueWrapper(fertiliser), fertiliser.getType());
    }

    @Override
    public void save() {
        item.setTitle(title);
        item.setAluminium(Double.parseDouble(valueWrapper.getAluminium().getValue()));
    }
}
