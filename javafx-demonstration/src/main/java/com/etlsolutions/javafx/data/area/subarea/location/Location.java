package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public abstract class Location extends DataUnit {

    @JsonIgnore
    public static final String REFERENCE_POINT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.REFERENCE_POINT_PROPERTY";
    @JsonIgnore
    public static final String DISTANCE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.DISTANCE_PROPERTY";
    
    private String referencePoint;
    private double distance;

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        String oldValue = this.referencePoint;
        this.referencePoint = referencePoint;
        fireChange(REFERENCE_POINT_PROPERTY, oldValue, this.referencePoint);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        
        double oldValue = this.distance;
        this.distance = distance;
        fireChange(DISTANCE_PROPERTY, oldValue, this.distance);
    }
}
