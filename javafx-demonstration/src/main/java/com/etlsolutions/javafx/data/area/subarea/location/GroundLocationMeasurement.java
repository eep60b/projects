package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurement implements LocationMeasurement {

    private LocationReferencePoint referencePoint;
    private LocationDirection direction;
    private double distance;
    private double occupiedArea;

    public GroundLocationMeasurement() {
    }

    public GroundLocationMeasurement(LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        this.referencePoint = referencePoint;
        this.direction = direction;
        this.distance = distance;
        this.occupiedArea = occupiedArea;
    }

    @Override
    public LocationMeasurementType getType() {
        return LocationMeasurementType.GROUND_LOCATION;
    }

    public LocationReferencePoint getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(LocationReferencePoint referencePoint) {
        this.referencePoint = referencePoint;
    }

    public LocationDirection getDirection() {
        return direction;
    }

    public void setDirection(LocationDirection direction) {
        this.direction = direction;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getOccupiedArea() {
        return occupiedArea;
    }

    public void setOccupiedArea(double occupiedArea) {
        this.occupiedArea = occupiedArea;
    }
    
    
}
