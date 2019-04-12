package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class PolygonMeasurementWrapper implements AreaMeasurable {

    @Override
    public String getAreaString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.POLYGON);
    }

    @Override
    public Measurement getMeasurement() {
        return new PolygonMeasurement(this);
    }
}