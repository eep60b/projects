package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public AddSubAreaDataModel(Area area) {
        super(area, area.getType().getSubAreaTypes(), new Measurement());
    }

    @Override
    public void save() {
        dataUnit = SubAreaFactory.getInstance().createSubArea(selectedSubAreaType, commonValueWrapper, measurementDataModel.getMeasurement());
        area.getSubAreas(selectedSubAreaType).add(dataUnit);
    }
}