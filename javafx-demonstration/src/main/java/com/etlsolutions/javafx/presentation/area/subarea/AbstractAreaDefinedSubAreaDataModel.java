package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public abstract class AbstractAreaDefinedSubAreaDataModel extends AbstractSubAreaDataModel {

    protected Area area;

    public AbstractAreaDefinedSubAreaDataModel(Area area, SubAreaMeasurement measurement) {
        super(area.getType().getSubAreaTypes(), measurement);
    }
}
