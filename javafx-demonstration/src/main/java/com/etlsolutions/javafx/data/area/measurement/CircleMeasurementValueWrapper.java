package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.gwise.data.ValueWrapper;
import static com.etlsolutions.gwise.system.SettingConstants.PI;

/**
 *
 * @author zc
 */
public class CircleMeasurementValueWrapper extends DoubleValueWrapper implements AreaMeasurable {

    private final ValueWrapper<String> diameterValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public CircleMeasurementValueWrapper(CircleMeasurement measurement) {
        diameterValueWrapper = getWrapper(measurement.getDiameter());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }

    public CircleMeasurementValueWrapper() {
        this(new CircleMeasurement());
    }

    public ValueWrapper<String> getDiameterValueWrapper() {
        return diameterValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    public double getDiameter() {
        return getValue(diameterValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    @Override
    public String getAreaString() {
        return String.valueOf(PI*getDiameter()*getDiameter()/4);
    }
    
    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.CIRCLE);
    }

    @Override
    public Measurement getMeasurement() {
        return new CircleMeasurement(this);
    }
}
