package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class NumberMeasurementValueWrapper implements MeasurementValueWrapper {

    private final ValueWrapper<Integer> numberValueWrapper;

    public NumberMeasurementValueWrapper() {
        numberValueWrapper = new ValueWrapper<>(0);
    }

    public NumberMeasurementValueWrapper(NumberMeasurement measurement) {
        numberValueWrapper = new ValueWrapper<>(measurement.getNumber());
    }

    public ValueWrapper<Integer> getNumberValueWrapper() {
        return numberValueWrapper;
    }

    @Override
    public ValueWrapper<MeasurementType> getType() {
        return new ValueWrapper<>(MeasurementType.NUMBER);
    }

    @Override
    public Measurement getMeasurement() {
        return new NumberMeasurement(this);
    }

}
