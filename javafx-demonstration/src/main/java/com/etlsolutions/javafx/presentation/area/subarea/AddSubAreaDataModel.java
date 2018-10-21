package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractSubAreaDataModel {

    public AddSubAreaDataModel(SubAreaType[] types) {
        super(null, new SubAreaMeasurement(), types);
    }

    @Override
    public void save() {
        subArea = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, title, information, imageLinks, imageLinks.indexOf(getSelectedImageLink()), "", selectedSubAreaShape, measurementDataModel.getMeasurement());
        area.getSubAreas(selectedSubAreaType).add(subArea);
    }
}
