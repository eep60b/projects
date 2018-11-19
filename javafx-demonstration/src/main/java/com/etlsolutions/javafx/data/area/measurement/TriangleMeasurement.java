package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class TriangleMeasurement implements Measurement {
    
    private double a;
    private double b;
    private double c;
    private double height; 

    public TriangleMeasurement() {
    }

    
    public TriangleMeasurement(TriangleMeasurementValueWrapper wrapper) {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.TRIANGLE;
    }
}
