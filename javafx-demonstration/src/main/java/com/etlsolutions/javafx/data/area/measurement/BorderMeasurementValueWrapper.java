package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class BorderMeasurementValueWrapper extends DoubleValueWrapper implements MeasurementValueWrapper {

    private final ValueWrapper<String> lengthValueWrapper;
    private final ValueWrapper<String> widthValueWrapper;

    public BorderMeasurementValueWrapper(BorderMeasurement measurement) {
        
        lengthValueWrapper = getWrapper(measurement.getLength());
        widthValueWrapper = getWrapper(measurement.getWidth());
    }

    public BorderMeasurementValueWrapper() {
        this(new BorderMeasurement());
    }

    public ValueWrapper<String> getLengthValueWrapper() {
        return lengthValueWrapper;
    }

    public ValueWrapper<String> getWidthValueWrapper() {
        return widthValueWrapper;
    }

    public double getLength() {
        return getValue(lengthValueWrapper);
    }

    public double getWidth() {
        return getValue(widthValueWrapper);
    }

    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.BORDER);
    }

    @Override
    public Measurement getMeasurement() {
        return new BorderMeasurement(this);
    }
}
