package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public class Location extends DataUnit {

    @JsonIgnore
    public static final String REFERENCE_POINT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.REFERENCE_POINT_PROPERTY";
    @JsonIgnore
    public static final String DISTANCE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.DISTANCE_PROPERTY";

    private String referencePoint;
    private double distance;
    private int plantsId;

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

    public int getPlantsId() {
        return plantsId;
    }

    /**
     * Set the ID of plants which use the location. This can only set once.
     *
     * @param plantsId - The ID of plants.
     */
    public void setPlantsId(int plantsId) {

        if (this.plantsId == 0) {
            this.plantsId = plantsId;
            return;
        }
        
        throw new IllegalStateException("The plants ID can only set once.");
    }
}
