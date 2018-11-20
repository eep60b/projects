package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class MeasurementDataModel <T extends MeasurementValueWrapper> {
    
    
    protected final T measurementValueWrapper;

    public MeasurementDataModel(T measurementValueWrapper) {
        this.measurementValueWrapper = measurementValueWrapper;
    }    
    
    public abstract String getFxmlPath();

    public T getMeasurementValueWrapper() {
        return measurementValueWrapper;
    }
}
