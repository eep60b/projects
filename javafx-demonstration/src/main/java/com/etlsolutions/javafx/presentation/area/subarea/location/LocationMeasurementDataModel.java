package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationSpecialValueWrapper;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class LocationMeasurementDataModel<T extends LocationMeasurement> {

    protected ValueWrapper<T> measurement;

    public LocationMeasurementDataModel(T measurement) {
        this.measurement = new ValueWrapper<>(measurement);
    }
    
    public abstract String getFxmlPath();

    public LocationMeasurementType getType(){
        return measurement.getValue().getType();
    }
}
