package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public interface MeasurementValueWrapper {

    ValueWrapper<MeasurementType> getTypeValueWrapper();
    
    Measurement getMeasurement();
}
