package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.ROOM;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class Room extends SubArea {

    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Room.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Room.CONTAINER_SETS_PROPERTY";

    private List<Container> containers;

    public List<Container> getContainers() {
        return new ArrayList<>(containers);
    }

    public void setContainers(List<Container> containers) {
        this.containers = new ArrayList<>(containers);
        fireChange(CONTAINERS_PROPERTY);
    }

    public boolean addContainer(Container container) {
        boolean added = containers.add(container);
        fireChange(CONTAINERS_PROPERTY, false, added);
        return added;
    }

    public boolean removeContainer(Container container) {
        boolean removed = containers.remove(container);
        fireChange(CONTAINERS_PROPERTY, false, removed);
        return removed;
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
