package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class RectangleMeasurementValueWrapper extends DoubleValueWrapper implements AreaMeasurable {

    private final ValueWrapper<String> lengthValueWrapper;
    private final ValueWrapper<String> widthValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public RectangleMeasurementValueWrapper(RectangleMeasurement measurement) {
        lengthValueWrapper = getWrapper(measurement.getLength());
        widthValueWrapper = getWrapper(measurement.getWidth());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }
    
    public RectangleMeasurementValueWrapper() {
        this(new RectangleMeasurement());
    }

    public ValueWrapper<String> getLengthValueWrapper() {
        return lengthValueWrapper;
    }

    public ValueWrapper<String> getWidthValueWrapper() {
        return widthValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    public double getLength() {
        return getValue(lengthValueWrapper);
    }

    public double getWidth() {
        return getValue(widthValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    @Override
    public String getAreaString() {
        return String.valueOf(getLength() * getWidth());
    }
    
    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.RECTANGLE);
    }

    @Override
    public RectangleMeasurement getMeasurement() {
        return new RectangleMeasurement(this);
    }
}
