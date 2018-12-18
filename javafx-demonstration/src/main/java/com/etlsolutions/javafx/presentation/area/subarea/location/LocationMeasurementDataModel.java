package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.location.LocationMeasurementType;
import com.etlsolutions.javafx.data.area.subarea.location.LocationSpecialValueWrapper;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class LocationMeasurementDataModel<T extends LocationSpecialValueWrapper> implements FXMLActionDataModel {

    protected T valueWrapper;

    public LocationMeasurementDataModel(T valueWrapper) {

        this.valueWrapper = valueWrapper;
    }

    public ValueWrapper<LocationMeasurementType> getTypeValueWrapper() {
        return valueWrapper.getTypeValueWrapper();
    }

    public T getMeasurement() {
        return valueWrapper;
    }

}
