package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaValueWrapper;

/**
 *
 * @author zc
 */
public abstract class AbstractAreaDefinedSubAreaDataModel extends AbstractSubAreaDataModel {

    protected Area area;

    public AbstractAreaDefinedSubAreaDataModel(SubAreaValueWrapper subAreaValueWrapper, Area area) {
        super(subAreaValueWrapper, area.getType().getSubAreaTypes());
    }

    public AbstractAreaDefinedSubAreaDataModel(SubAreaValueWrapper subAreaValueWrapper, SubArea subArea, Area area, SubAreaType[] subAreaTypes, Measurement measurement) {
        super(subAreaValueWrapper, subArea, subAreaTypes, measurement);
    }    
}
