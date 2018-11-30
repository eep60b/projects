package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
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
        super(subAreaTypes, new RectangleMeasurement());
    }

    @Override
    public void save() {
        set(SubAreaFactory.getInstance().createSubArea(selectedSubAreaType.getValue(), commonValueWrapper, measurementDataModel.getValue().getMeasurementValueWrapper().getMeasurement()));
    }
}
