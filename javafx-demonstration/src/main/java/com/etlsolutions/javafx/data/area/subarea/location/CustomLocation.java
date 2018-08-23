package com.etlsolutions.javafx.data.area.subarea.location;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class CustomLocation extends Location {
    
    @JsonIgnore
    public static final String DIRECTION_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.CustomLocation.REFERENCE_POINT_PROPERTY";
    
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        
        String oldValue = this.direction;
        this.direction = direction;
        fireChange(DIRECTION_PROPERTY, oldValue, this.direction);
    }
}
