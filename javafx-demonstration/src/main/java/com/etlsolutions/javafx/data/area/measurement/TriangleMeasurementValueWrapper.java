package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class TriangleMeasurementValueWrapper extends DoubleValueWrapper implements AreaMeasurable {

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

    public ValueWrapper<String> getAValueWrapper() {
        return aValueWrapper;
    }

    public ValueWrapper<String> getBValueWrapper() {
        return bValueWrapper;
    }

    public ValueWrapper<String> getCValueWrapper() {
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
    public String getAreaString() {
        double a = getA();
        double b = getB();
        double c = getC();
        double s = a + b + c;
        
        return String.valueOf(Math.sqrt(s *(s-a) * (s-b) * (s-c))/2);
        
        
    }
    
    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.TRIANGLE);
    }

    @Override
    public Measurement getMeasurement() {
        return new TriangleMeasurement(this);
    }
}
