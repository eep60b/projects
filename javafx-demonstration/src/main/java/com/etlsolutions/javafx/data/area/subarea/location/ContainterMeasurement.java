package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class ContainterMeasurement implements LocationMeasurement {

    private ContainerShape shape;
    private double height;
    private double volume;

    public ContainterMeasurement() {
    }

    public ContainterMeasurement(ContainerShape shape, int height, int volume) {
        this.shape = shape;
        this.height = height;
        this.volume = volume;
    }

    public ContainerShape getShape() {
        return shape;
    }

    public void setShape(ContainerShape shape) {
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
