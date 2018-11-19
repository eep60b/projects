package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class CircleMeasurement implements Measurement {

    private double diameter;
    private double height;

    public CircleMeasurement() {
    }

    public CircleMeasurement(CircleMeasurementValueWrapper wrapper) {
        this.diameter = wrapper.getDiameter();
        this.height = wrapper.getHeight();
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public MeasurementType getType() {
        return MeasurementType.CIRCLE;
    }
}
