package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomSubarea extends SubAreaK {

    private final ObservableList<CustomLocation> locations;
    private final ObservableList<Container> containers;

    public CustomSubarea() {
        locations = FXCollections.observableArrayList();
        containers = FXCollections.observableArrayList();
    }

    public ObservableList<CustomLocation> getLocations() {
        return locations;
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public void updateAllLocations() {
        allLocations.addAll(locations);
        allLocations.addAll(containers);        
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CUSTOM;
    }

}
