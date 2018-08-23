package com.etlsolutions.javafx.data.area.subarea;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class RaisedPlantBed extends  PlantBed {
  
    @JsonIgnore
    public static final String HEIGHT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.HEIGHT_PROPERTY";    
    
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        double oldValue = this.height;
        this.height = height;
        fireChange(HEIGHT_PROPERTY, oldValue, this.height);
    }
}
