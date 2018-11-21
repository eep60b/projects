package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class IrregularMeasurementValueWrapper extends DoubleValueWrapper implements AreaMeasurable {
    
    private final ValueWrapper<String> areaValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public IrregularMeasurementValueWrapper(IrregularMeasurement measurement) {
        areaValueWrapper = getWrapper(measurement.getArea());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }

    public IrregularMeasurementValueWrapper() {
        this(new IrregularMeasurement());
    }

    public ValueWrapper<String> getAreaValueWrapper() {
        return areaValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }
    
    public double getArea() {
        return getValue(areaValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.IRREGULAR);
    }

    @Override
    public String getAreaString() {
        return String.valueOf(getArea());
    }

    @Override
    public Measurement getMeasurement() {
        return new IrregularMeasurement(this);
    }
}
