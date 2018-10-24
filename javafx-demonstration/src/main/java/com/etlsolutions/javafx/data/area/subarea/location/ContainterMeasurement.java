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

    public String getShape() {
        return shape.getTitle();
    }

    public void setShape(String title) {
        this.shape.setTitle(title);
    }
 
    
    public String getHeight() {
        return String.valueOf(height);
    }

    public void setHeight(String height) {
        this.height = Double.parseDouble(height);
    }

    public String getVolume() {
        return String.valueOf(volume);
    }

    public void setVolume(String volume) {
        this.volume = Double.parseDouble(volume);
    }

    @Override
    public LocationMeasurementType getType() {
        return LocationMeasurementType.CONTAINER;
    } 
}
