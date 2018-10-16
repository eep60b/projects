package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PlantBed extends SubArea {

    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.SHAPE_PROPERTY";
    @JsonIgnore
    public static final String AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.AREA_PROPERTY";    
    @JsonIgnore
    public static final String LOCATIONS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.LOCATIONS_PROPERTY";


    private String shape;
    private double area;
    private ObservableList<PlantBedLocation> locations;

    public PlantBed() {
        locations = FXCollections.observableArrayList();
    }

    
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        String oldValue = this.shape;
        this.shape = shape;
        fireChange(SHAPE_PROPERTY, oldValue, this.shape);
        
    }

    public double getArea() {
        return area;
    }

    public ObservableList<PlantBedLocation> getLocations() {
        return locations;
    }

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.PLANT_BED;
    }
    
    
    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.PLANT_BED_LOCATION);
    }  
}
