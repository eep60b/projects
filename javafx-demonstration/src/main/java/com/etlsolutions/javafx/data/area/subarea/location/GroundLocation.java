package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class GroundLocation extends Location {

    @JsonIgnore
    public static final String REFERENCE_POINT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.GroundLocation.Location.REFERENCE_POINT_PROPERTY";
    @JsonIgnore
    public static final String DISTANCE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.DISTANCE_PROPERTY";
    @JsonIgnore
    public static final String DIRECTION_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.DIRECTION_PROPERTY";
    @JsonIgnore
    public static final String OCCUPIED_AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.GroundLocation.OCCUPIED_AREA_PROPERTY";

    private LocationReferencePoint referencePoint;
    private LocationDirection direction;
    private double distance;    
    private double occupiedArea;
    private int plantsId;

    public GroundLocation() {
    }

    public GroundLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.referencePoint = referencePoint;
        this.direction = direction;
        this.distance = distance;
        this.occupiedArea = occupiedArea;

    }

    public GroundLocation(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.referencePoint = referencePoint;
        this.direction = direction;
        this.distance = distance;
        this.occupiedArea = occupiedArea;
    }

    public LocationReferencePoint getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(LocationReferencePoint referencePoint) {
        LocationReferencePoint oldValue = this.referencePoint;
        this.referencePoint = referencePoint;
        fireChange(REFERENCE_POINT_PROPERTY, oldValue, this.referencePoint);
    }

    public double getDistance() {
        return distance;
    }

    public LocationDirection getDirection() {
        return direction;
    }

    public void setDirection(LocationDirection direction) {

        LocationDirection oldValue = this.direction;
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
