package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public AddSubAreaDataModel(Area area) {
        super(area, area.getType().getSubAreaTypes(), new SubAreaMeasurement());
    }

    @Override
    public void save() {
        dataUnit = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, commonValueWrapper, selectedSubAreaShape, measurementDataModel.getMeasurement());
        area.getSubAreas(selectedSubAreaType).add(dataUnit);
    }
}