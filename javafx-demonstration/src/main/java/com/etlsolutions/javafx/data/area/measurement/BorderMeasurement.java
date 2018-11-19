package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class BorderMeasurement implements Measurement {

    private double length;
    private double width;

    public BorderMeasurement() {
    }

    public BorderMeasurement(BorderMeasurementValueWrapper wrapper) {
        
        length = wrapper.getLength();
        width = wrapper.getWidth();
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

    @Override
    public MeasurementType getType() {
        return MeasurementType.BORDER;
    }
}
