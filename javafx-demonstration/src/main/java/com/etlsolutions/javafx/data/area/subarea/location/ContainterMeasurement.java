package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class ContainterMeasurement implements LocationMeasurement {
    
    private String height;
    
    private String volume;

    public ContainterMeasurement() {
    }

    public ContainterMeasurement(String height, String volume) {
        this.height = height;
        this.volume = volume;
    }
    
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    
    
}
