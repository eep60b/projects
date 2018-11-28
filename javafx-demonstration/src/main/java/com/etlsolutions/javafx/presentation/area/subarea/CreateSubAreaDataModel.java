package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class CreateSubAreaDataModel extends AbstractSubAreaDataModel {

    public CreateSubAreaDataModel(SubAreaType[] subAreaTypes) {
        super(subAreaTypes, new RectangleMeasurement());
    }

    @Override
    public void save() {
        set(SubAreaFactory.getInstance().createSubArea(selectedSubAreaType.getValue(), commonValueWrapper,  measurementDataModel.getValue().getMeasurementValueWrapper().getMeasurement()));
    }
}
