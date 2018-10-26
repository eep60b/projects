package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.BorderLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
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
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.BORDER;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case BORDER_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.BORDER_LOCATION);
    }
}
