package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.measurement.MeasurementFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 * The CreateSubAreaDataModel class can be used to create a SubArea without
 * parent. Its parent id should be 0 when created and it has to be set later.
 *
 * @author zc
 */
public class CreateSubAreaDataModel extends AbstractSubAreaDataModel {

    public CreateSubAreaDataModel(SubAreaType[] subAreaTypes) {
        super(subAreaTypes);
    }

    @Override
    public void save() {
        set(SubAreaFactory.getInstance().createSubArea(selectedSubAreaTypeValueWrapper.getValue(), commonValueWrapper, measurementDataModel.getMeasurementValueWrapper().getMeasurement()));
    }
}
