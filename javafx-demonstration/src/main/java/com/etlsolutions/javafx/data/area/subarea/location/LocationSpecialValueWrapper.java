package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 * @param <T>
 */
public interface LocationSpecialValueWrapper<T> {
    
    ValueWrapper<T> getTypeValueWrapper();
    
    LocationMeasurement getMeasurement();
}
