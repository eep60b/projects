package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurement;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class LocationMeasurementDataModel<T extends LocationMeasurement> {

    protected T measurement;

    public LocationMeasurementDataModel(T measurement) {
        this.measurement = measurement;
    }
    
    public abstract String getFxmlPath();

    public LocationMeasurementType getType(){
        return measurement.getType();
    }
}
