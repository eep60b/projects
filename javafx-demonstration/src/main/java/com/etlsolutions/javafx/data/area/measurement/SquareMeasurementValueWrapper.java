package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class SquareMeasurementValueWrapper extends DoubleValueWrapper implements AreaMeasurable {
    
    private final ValueWrapper<String> sideValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;
    
    public SquareMeasurementValueWrapper(SquareMeasurement measurement) {
        sideValueWrapper = getWrapper(measurement.getSide());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }

    public SquareMeasurementValueWrapper() {
        this(new SquareMeasurement());
    }

    public ValueWrapper<String> getSideValueWrapper() {
        return sideValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    public double getSide() {
        return getValue(sideValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }
    
    @Override
    public String getAreaString() {
        return String.valueOf(getSide() * getSide());
    }
    
    @Override
    public ValueWrapper<MeasurementType> getType() {
        
        return new ValueWrapper<>(MeasurementType.SQUARE);
    }

    @Override
    public Measurement getMeasurement() {
        return new SquareMeasurement(this);
    }
}
