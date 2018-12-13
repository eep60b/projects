package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class MeasurementDataModel <T extends MeasurementValueWrapper> implements FXMLActionDataModel{
    
    
    protected final T measurementValueWrapper;

    public MeasurementDataModel(T measurementValueWrapper) {
        this.measurementValueWrapper = measurementValueWrapper;
    }    
 
    public T getMeasurementValueWrapper() {
        return measurementValueWrapper;
    }
}
