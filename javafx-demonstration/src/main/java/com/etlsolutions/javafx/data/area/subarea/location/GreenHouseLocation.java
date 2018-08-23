package com.etlsolutions.javafx.data.area.subarea.location;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class GreenHouseLocation extends Location {
    
    @JsonIgnore
    public static final String DIRECTION_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GreenHouseLocation.REFERENCE_POINT_PROPERTY";
    
    private String directtion;

    public String getDirecttion() {
        return directtion;
    }

    public void setDirecttion(String directtion) {
        
        String oldValue = this.directtion;
        this.directtion = directtion;
        fireChange(DIRECTION_PROPERTY, oldValue, this.directtion);
    }
}
