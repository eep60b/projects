package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class RectangleMeasurementValueWrapper extends DoubleValueWrapper implements MeasurementValueWrapper {

    private final ValueWrapper<String> lengthValueWrapper;
    private final ValueWrapper<String> widthValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public RectangleMeasurementValueWrapper(double length, double width, double height) {
        lengthValueWrapper = getWrapper(length);
        widthValueWrapper = getWrapper(width);
        heightValueWrapper = getWrapper(height);
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
    public MeasurementType getType() {
        return MeasurementType.RECTANGLE;
    }
}
