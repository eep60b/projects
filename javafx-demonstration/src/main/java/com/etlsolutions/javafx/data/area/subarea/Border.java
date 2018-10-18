package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.BorderLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Border extends SubArea {

    @JsonIgnore
    public static final String LENGTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.LENGTH_PROPERTY";
    @JsonIgnore
    public static final String WIDTH_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.PlantBedBorder.WIDTH_PROPERTY";

    private double length;
    private double width;
    private final ObservableList<BorderLocation> locations;

    public Border() {        
        locations = FXCollections.observableArrayList();
    }

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

    public ObservableList<BorderLocation> getLocations() {
        return locations;
    }

    @Override
    public void updateAllLocations() {
        allLocations.addAll(locations);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.BORDER;
    }
}
