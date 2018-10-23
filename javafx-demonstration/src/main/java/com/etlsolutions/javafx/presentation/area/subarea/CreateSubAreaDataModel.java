package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class CreateSubAreaDataModel extends AbstractSubAreaDataModel {

    public CreateSubAreaDataModel(SubAreaType[] subAreaTypes) {
        super(subAreaTypes, new SubAreaMeasurement());
    }

    @Override
    public void save() {
        subArea = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, title, information, imageLinks, imageLinks.indexOf(getSelectedImageLink()), "", selectedSubAreaShape, measurementDataModel.getMeasurement());
    }
}
