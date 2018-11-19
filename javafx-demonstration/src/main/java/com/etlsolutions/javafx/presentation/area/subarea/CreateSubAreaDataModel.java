package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class CreateSubAreaDataModel extends AbstractSubAreaDataModel {

    public CreateSubAreaDataModel(SubAreaType[] subAreaTypes) {
        super(subAreaTypes, new Measurement());
    }

    @Override
    public void save() {
        dataUnit = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, commonValueWrapper, selectedSubAreaShape, measurementDataModel.getMeasurement());
    }
}
