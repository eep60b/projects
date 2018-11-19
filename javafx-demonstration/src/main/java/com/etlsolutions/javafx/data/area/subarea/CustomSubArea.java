package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomSubArea extends SubArea {

    private ObservableList<CustomLocation> customlocations;
    private ObservableList<Container> containers;

    public CustomSubArea() {

    }

    public CustomSubArea(Measurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.customlocations = new ObservableListWrapperA<>();
        this.containers = new ObservableListWrapperA<>();
    }


    public ObservableList<CustomLocation> getCustomlocations() {
        return customlocations;
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(customlocations);
        list.addAll(containers);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CUSTOM;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {

        ObservableListWrapperA<Location> locations = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINER:
                locations.addAll(containers);
                break;
            case CUSTOMER_LOCATION:
                locations.addAll(customlocations);
                break;
        }
        return locations;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CUSTOMER_LOCATION);
    }
}
