package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class GroundLocationMeasurement implements LocationMeasurement {

    private String referencePoint;
    private String direction;
    private double distance;
    private double occupiedArea;

    public GroundLocationMeasurement() {
    }

    public GroundLocationMeasurement(GroundLocationMeasurementValueWrapper wrapper) {
        referencePoint = wrapper.getReferencePointValueWrapper().getValue();
        direction = wrapper.getDirectionValueWrapper().getValue();
        distance = wrapper.getDistance();
        occupiedArea = wrapper.getOccupiedArea();
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
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

    @Override
    public LocationMeasurementType getType() {
        return LocationMeasurementType.GROUND_LOCATION;
    }

}
