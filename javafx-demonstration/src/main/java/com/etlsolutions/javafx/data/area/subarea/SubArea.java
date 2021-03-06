package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Movable;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Container set, border area, raised-bed, normal-plant-bed
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @Type(name = "Border", value = Border.class),
    @Type(name = "ContainerSubarea", value = ContainerSet.class),
    @Type(name = "CustomSubArea", value = CustomSubArea.class),
    @Type(name = "Greenhouse", value = Greenhouse.class),
    @Type(name = "Lawn", value = Lawn.class),
    @Type(name = "PlantBed", value = PlantBed.class),
    @Type(name = "Pond", value = Pond.class),
    @Type(name = "RaisedPlantBed", value = RaisedPlantBed.class),
    @Type(name = "Room", value = Room.class),
    @Type(name = "SingleContainer", value = SingleContainer.class)
})
public abstract class SubArea extends DataUnit implements Movable {

    @JsonIgnore
    public static final String MEASUREMENT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.MEASUREMENT_PROPERTY";
    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.SHAPE_PROPERTY";

    protected ObservableListWrapperA<Location> locations;
    protected Measurement measurement;
    protected SubAreaShape shape;
    
    private int parentId;
    private double centerX;
    private double centerY;
    private double ocuppiedWidth;
    private double occuppiedHeight;
    private double[] points;
    
    public SubArea() {

    }

    public SubArea(Measurement measurement, DataUnitValueWrapper valueWrapper) {
        super(valueWrapper);
        this.measurement = measurement;
    }

    @JsonIgnore
    public abstract SubAreaType getType();

    public abstract ObservableListWrapperA<Location> getLocations(LocationType type);

    @JsonIgnore
    public abstract ObservableListWrapperA<Location> getAllLocations();

    @JsonIgnore
    public abstract ObservableListWrapperA<LocationType> getLocationTypes();

    public ObservableListWrapperA<Location> getLocations() {
        return locations;
    }

    public void setLocations(ObservableListWrapperA<Location> locations) {
        this.locations = locations;
    }
    
    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
        support.fireChange(MEASUREMENT_PROPERTY);
    }

    public SubAreaShape getShape() {
        return shape;
    }

    public void setShape(SubAreaShape shape) {
        SubAreaShape oldValue = this.shape;
        this.shape = shape;
        support.fireChange(SHAPE_PROPERTY, oldValue, this.shape);
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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
