package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.PondLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Pond extends SubArea {

    
    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Pond.SHAPE_PROPERTY";
    @JsonIgnore
    public static final String AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Pond.AREA_PROPERTY";    
    @JsonIgnore
    public static final String LOCATIONS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Pond.LOCATIONS_PROPERTY";


    private String shape;
    private double area;
    private final ObservableList<PondLocation> locations;

    public Pond() {
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

    public void setArea(double area) {
        double oldValue = this.area;
        this.area = area;
        fireChange(AREA_PROPERTY, oldValue, this.area);
    }

    public ObservableList<PondLocation> getLocations() {
        return locations;
    }


    public boolean addLocations(PondLocation location) {
        boolean added = locations.add(location);
        fireChange(LOCATIONS_PROPERTY, false, added);
        return added;
    }

    public boolean removeLocations(PondLocation location) {
        boolean removed = locations.remove(location);
        fireChange(LOCATIONS_PROPERTY, false, removed);
        return removed;
    }

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.POND;
    }
}
