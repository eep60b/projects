package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.GreenHouseGroundLocation;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Greenhouse extends SubArea {

    private final ObservableList<GreenHouseGroundLocation> locations;
    private final ObservableList<Container> containers;

    public Greenhouse() {
        locations = FXCollections.observableArrayList();
        containers = FXCollections.observableArrayList();
    }

    public ObservableList<GreenHouseGroundLocation> getLocations() {
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
        return SubAreaType.GREEN_HOUSE;
    }

    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.CONTAINER, LocationType.GREEN_HOUSE_GROUND_LOCATION);
    }  
}
