package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomSubArea extends SubArea {

    private final ObservableList<CustomLocation> locations;
    private final ObservableList<Container> containers;

    public CustomSubArea() {
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
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

    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.CONTAINER, LocationType.CUSTOMER_LOCATION);
    }    
}
