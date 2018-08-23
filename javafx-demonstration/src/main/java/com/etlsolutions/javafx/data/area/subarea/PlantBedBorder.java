package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.BorderLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantBedBorder extends Subarea {

    @JsonIgnore
    public static final String LENGTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.LENGTH_PROPERTY";
    @JsonIgnore
    public static final String WIDTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.WIDTH_PROPERTY";
    @JsonIgnore
    public static final String LOCATIONS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.LOCATIONS_PROPERTY";

    private double length;
    private double width;
    private List<BorderLocation> locations;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        double oldValue = this.length;
        this.length = length;
        fireChange(LENGTH_PROPERTY, oldValue, this.length);

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        double oldValue = this.width;
        this.width = width;
        fireChange(WIDTH_PROPERTY, oldValue, this.width);
    }

    public ArrayList<BorderLocation> getLocations() {
        return new ArrayList<>(locations);
    }

    public void setLocations(List<BorderLocation> locations) {
        this.locations = new ArrayList<>(locations);
        fireChange(LOCATIONS_PROPERTY);
    }

    public boolean addLocations(BorderLocation location) {
        boolean added = locations.add(location);
        fireChange(LOCATIONS_PROPERTY, false, added);
        return added;
    }

    public boolean removeLocations(BorderLocation location) {
        boolean removed = locations.remove(location);
        fireChange(LOCATIONS_PROPERTY, false, removed);
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }
}
