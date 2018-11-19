package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class TriangleMeasurementValueWrapper extends DoubleValueWrapper implements MeasurementValueWrapper {

    private final ValueWrapper<String> aValueWrapper;
    private final ValueWrapper<String> bValueWrapper;
    private final ValueWrapper<String> cValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public TriangleMeasurementValueWrapper(TriangleMeasurement measurement) {
        aValueWrapper = getWrapper(measurement.getA());
        bValueWrapper = getWrapper(measurement.getB());
        cValueWrapper = getWrapper(measurement.getC());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }

    public TriangleMeasurementValueWrapper() {
        this(new TriangleMeasurement());
    }

    public ValueWrapper<String> getaValueWrapper() {
        return aValueWrapper;
    }

    public ValueWrapper<String> getbValueWrapper() {
        return bValueWrapper;
    }

    public ValueWrapper<String> getcValueWrapper() {
        return cValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    
    public double getA() {
        return getValue(aValueWrapper);
    }

    public double getB() {
        return getValue(bValueWrapper);
    }

    public double getC() {
        return getValue(cValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.TRIANGLE;
    }
}
