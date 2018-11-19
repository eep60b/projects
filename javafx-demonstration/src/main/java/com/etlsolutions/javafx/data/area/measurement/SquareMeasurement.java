package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class SquareMeasurement implements Measurement {
    
    private double side;
    private double height;

    public SquareMeasurement() {
    }

    public SquareMeasurement(SquareMeasurementValueWrapper wrapper) {
        side = wrapper.getSide();
        height = wrapper.getHeight();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.SQUARE;
    }
}
