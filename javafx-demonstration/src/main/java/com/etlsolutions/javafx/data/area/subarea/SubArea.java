package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Container set, border area, raised-bed, normal-plant-bed
 *
 * @author zc
 */
public abstract class SubArea extends DataUnit {

    @JsonIgnore
    public static final String MEASUREMENT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.MEASUREMENT_PROPERTY";
    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.SHAPE_PROPERTY";
    
    protected Measurement measurement;
    protected SubAreaShape shape;
    private int parentId;    
    
    public SubArea() {

    }

    public SubArea(Measurement measurement, DataUnitValueWrapper valueWrapper) {
        super(valueWrapper);
        this.measurement = measurement;
    }

    public abstract SubAreaType getType();
    
    public abstract ObservableListWrapperA<Location> getLocations(LocationType type);
    
    public abstract ObservableListWrapperA<Location> getAllLocations();
    
    public abstract ObservableListWrapperA<LocationType> getLocationTypes();

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
}
