package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public interface LocationSpecialValueWrapper {
    
    ValueWrapper<LocationMeasurementType> getTypeValueWrapper();
    
    LocationMeasurement getMeasurement();
}
