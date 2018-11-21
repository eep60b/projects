package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public interface MeasurementValueWrapper {

    ValueWrapper<MeasurementType> getTypeValueWrapper();
    
    Measurement getMeasurement();
}
