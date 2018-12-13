package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaFactory;

/**
 *
 * @author zc
 */
public class AddSubAreaDataModel extends AbstractAreaDefinedSubAreaDataModel {

    public AddSubAreaDataModel(Area area) {
        super(area, area.getType().getSubAreaTypes(), new RectangleMeasurement());
    }

    @Override
    public void save() {
        set(SubAreaFactory.getInstance().createSubArea(selectedSubAreaType.getValue(), commonValueWrapper, measurementDataModel.getMeasurementValueWrapper().getMeasurement()));
        area.getSubAreas(selectedSubAreaType.getValue()).add(get());
    }
}