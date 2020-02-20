package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.ROOM;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public class Room extends SubArea {

    private ObservableListWrapperA<Container> containers;

    public Room() {
    }

    public Room(Measurement measurement, DataUnitValueWrapper valueWrapper) {
        super(measurement, valueWrapper);
        this.containers = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<Container> getContainers() {
        return containers;
    }

    public void setContainers(ObservableListWrapperA<Container> containers) {
        this.containers = containers;
    }
    
    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(containers);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return ROOM;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINER:
                list.addAll(containers);
                break;
        }
        return list;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CONTAINER);
    }
}
