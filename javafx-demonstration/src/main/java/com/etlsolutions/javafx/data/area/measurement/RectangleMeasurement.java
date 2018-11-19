package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class RectangleMeasurement implements Measurement {

    private double length;
    private double width;
    private double height;
    
    public RectangleMeasurement() {
    }

    public RectangleMeasurement(RectangleMeasurementValueWrapper wrapper) {
        length = wrapper.getLength();
        width = wrapper.getWidth();
        height = wrapper.getHeight();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
        
    @Override
    public MeasurementType getType() {
        return MeasurementType.RECTANGLE;
    }
}
