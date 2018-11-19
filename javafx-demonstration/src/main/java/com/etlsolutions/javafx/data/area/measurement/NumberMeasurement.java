package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class NumberMeasurement implements Measurement {

    private int number;

    public NumberMeasurement() {
    }
    
    public NumberMeasurement(NumberMeasurementValueWrapper wrapper) {
        number = wrapper.getNumberValueWrapper().getValue();
    }
    
    public NumberMeasurement(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.NUMBER;
    }
}
