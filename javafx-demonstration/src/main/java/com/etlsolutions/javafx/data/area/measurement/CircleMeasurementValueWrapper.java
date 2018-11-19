package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class CircleMeasurementValueWrapper extends DoubleValueWrapper implements Measurement {

    private final ValueWrapper<String> diameterValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public CircleMeasurementValueWrapper(CircleMeasurement measurement) {
        this.diameterValueWrapper = getWrapper(measurement.getDiameter());
        this.heightValueWrapper = getWrapper(measurement.getHeight());
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
    public MeasurementType getType() {
        return MeasurementType.CIRCLE;
    }
}
