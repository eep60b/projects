package com.etlsolutions.javafx.data.area.subarea.location;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class Container extends Location {

    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.SHAPE_PROPERTY";
    @JsonIgnore
    public static final String HEIGHT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.HEIGHT_PROPERTY";
    @JsonIgnore
    public static final String VOLUMN_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.VOLUMN_PROPERTY";
    
    private String shape;
    private double height;
    private double volumn;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        String oldValue = this.shape;
        this.shape = shape;
        fireChange(SHAPE_PROPERTY, oldValue, this.shape);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        double oldValue = this.height;
        this.height = height;
        fireChange(HEIGHT_PROPERTY, oldValue, this.height);
    }

    public double getVolumn() {
        return volumn;
    }

    public void setVolumn(double volumn) {
        double oldValue = this.volumn;
        this.volumn = volumn;
        fireChange(VOLUMN_PROPERTY, oldValue, this.volumn);
    }
}
