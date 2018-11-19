package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public abstract class AbstractAreaDefinedSubAreaDataModel extends AbstractSubAreaDataModel {

    protected Area area;

    public AbstractAreaDefinedSubAreaDataModel(Area area, SubAreaType[] subAreaTypes, Measurement measurement) {
        super(subAreaTypes, measurement);
    }
}
