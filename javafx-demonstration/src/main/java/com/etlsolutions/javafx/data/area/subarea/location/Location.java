package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Movable;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An Location object record the location of a set of same plants.The
 * relationship between Plants objects and Location objects are one-to-one.
 *
 * @author zc
 */
public abstract class Location extends DataUnit implements Movable {

    @JsonIgnore
    public static final String PLANT_ID_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.PLANT_ID_PROPERTY";
    @JsonIgnore
    public static final String PARENT_ID_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.PARENT_ID_PROPERTY";

    private int plantId;
    private int parentId;
    private double centerX;
    private double centerY;
    private double ocuppiedWidth;
    private double occuppiedHeight;
    private double[] points;    

    public Location() {
    }

    public Location(LocationValueWrapper locationValueWrapper) {
        super(locationValueWrapper);
        plantId = locationValueWrapper.getPlantIdValueWrapper().getValue();
        parentId = locationValueWrapper.getParentIdValueWrapper().getValue();
    }

    public abstract LocationType getType();

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {

        int oldValue = this.plantId;
        this.plantId = plantId;
        support.fireChange(PLANT_ID_PROPERTY, oldValue, this.plantId);
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        int oldValue = this.parentId;
        this.parentId = parentId;
        support.fireChange(PARENT_ID_PROPERTY, oldValue, this.parentId);
    }

    @Override
    public double getCenterX() {
        return centerX;
    }

    @Override
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    @Override
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    @Override
    public double getOcuppiedWidth() {
        return ocuppiedWidth;
    }

    @Override
    public void setOcuppiedWidth(double ocuppiedWidth) {
        this.ocuppiedWidth = ocuppiedWidth;
    }

    @Override
    public double getOccuppiedHeight() {
        return occuppiedHeight;
    }

    @Override
    public void setOccuppiedHeight(double occuppiedHeight) {
        this.occuppiedHeight = occuppiedHeight;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }    
}
