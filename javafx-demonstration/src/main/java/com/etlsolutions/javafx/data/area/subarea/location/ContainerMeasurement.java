package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class ContainerMeasurement implements LocationMeasurement {

    private String shape;
    private double height;
    private double volume;

    public ContainerMeasurement() {
    }

    public ContainerMeasurement(ContainterMeasurementValueWrapper wrapper) {
        shape = wrapper.getShapeValueWrapper().getValue();
        height = wrapper.getHeight();
        volume = wrapper.getVolume();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public LocationMeasurementType getType() {
        return LocationMeasurementType.CONTAINER;
    }
}
