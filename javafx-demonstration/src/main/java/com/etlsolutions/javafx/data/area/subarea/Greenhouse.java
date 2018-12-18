package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.GreenHouseGroundLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public class Greenhouse extends SubArea {

    private ObservableListWrapperA<Container> containers;

    public Greenhouse() {
    }

    public Greenhouse(Measurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.locations = new ObservableListWrapperA<>();
        this.containers = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<Container> getContainers() {
        return containers;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        list.addAll(containers);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.GREEN_HOUSE;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINER:
                list.addAll(containers);
                break;
            case GREEN_HOUSE_GROUND_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CONTAINER, LocationType.GREEN_HOUSE_GROUND_LOCATION);
    }
}
