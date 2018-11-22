package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public abstract class GroundLocation extends Location {

    @JsonIgnore
    public static final String REFERENCE_POINT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.GroundLocation.Location.REFERENCE_POINT_PROPERTY";
    @JsonIgnore
    public static final String DISTANCE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.DISTANCE_PROPERTY";
    @JsonIgnore
    public static final String DIRECTION_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.DIRECTION_PROPERTY";
    @JsonIgnore
    public static final String OCCUPIED_AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.OCCUPIED_AREA_PROPERTY";

    private String referencePoint;
    private String direction;
    private double distance;
    private double occupiedArea;

    public GroundLocation() {
    }

    public GroundLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper);
        this.referencePoint = measurement.getReferencePoint();
        this.direction = measurement.getDirection();
        this.distance = measurement.getDistance();
        this.occupiedArea = measurement.getOccupiedArea();
    }

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {

        String oldValue = this.direction;
        this.direction = direction;
        fireChange(DIRECTION_PROPERTY, oldValue, this.direction);
    }

    public void setDistance(double distance) {

        double oldValue = this.distance;
        this.distance = distance;
        fireChange(DISTANCE_PROPERTY, oldValue, this.distance);
    }

    public double getOccupiedArea() {
        return occupiedArea;
    }

    public void setOccupiedArea(double occupiedArea) {
        double oldValue = this.occupiedArea;
        this.occupiedArea = occupiedArea;
        fireChange(OCCUPIED_AREA_PROPERTY, oldValue, this.occupiedArea);
    }
}
