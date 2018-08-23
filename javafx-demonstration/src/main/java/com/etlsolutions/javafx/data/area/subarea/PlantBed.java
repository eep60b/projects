package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantBed extends Subarea {

    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.SHAPE_PROPERTY";
    @JsonIgnore
    public static final String AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.AREA_PROPERTY";    
    @JsonIgnore
    public static final String LOCATIONS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBed.LOCATIONS_PROPERTY";


    private String shape;
    private double area;
    private List<PlantBedLocation> locations;

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
    
    public ArrayList<PlantBedLocation> getLocations() {
        return new ArrayList<>(locations);
    }

    public void setLocations(List<PlantBedLocation> locations) {
        this.locations = new ArrayList<>(locations);
        fireChange(LOCATIONS_PROPERTY);
    }

    public boolean addLocations(PlantBedLocation location) {
        boolean added = locations.add(location);
        fireChange(LOCATIONS_PROPERTY, false, added);
        return added;
    }

    public boolean removeLocations(PlantBedLocation location) {
        boolean removed = locations.remove(location);
        fireChange(LOCATIONS_PROPERTY, false, removed);
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }
}
