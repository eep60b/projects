package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class ContainerSetMeasurement implements Measurement {

    private int number;
    private double volume;
    private double height;

    public ContainerSetMeasurement() {
    }
    
    public ContainerSetMeasurement(ContainerSetMeasurementValueWrapper wrapper) {
        number = wrapper.getNumberValueWrapper().getValue();
    }
     
    public ContainerSetMeasurement(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.NUMBER;
    }
}
