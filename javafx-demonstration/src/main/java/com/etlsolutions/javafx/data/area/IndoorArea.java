package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class IndoorArea extends Area {

    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.IndoorArea.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.IndoorArea.CONTAINER_SETS_PROPERTY";
    @JsonIgnore
    public static final String ROOMS_PROPERTY = "com.etlsolutions.javafx.data.area.IndoorArea.ROOMS_PROPERTY";
    
    private List<Container> containers;
    private List<ContainerSet> containerSets;
    private List<Room> rooms;

    public List<ContainerSet> getContainerSets() {
        return new ArrayList<>(containerSets);
    }

    public void setContainerSets(List<ContainerSet> containerSets) {
        this.containerSets = new ArrayList<>(containerSets);
        fireChange(CONTAINER_SETS_PROPERTY);
    }

    public boolean addContainer(ContainerSet containerSet) {
        boolean added = containerSets.add(containerSet);
        fireChange(CONTAINER_SETS_PROPERTY, false, added);
        return added;
    }

    public boolean removeContainer(ContainerSet containerSet) {
        boolean removed = containerSets.remove(containerSet);
        fireChange(CONTAINER_SETS_PROPERTY, false, removed);
        return removed;
    }

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

    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = new ArrayList<>(rooms);
        fireChange(ROOMS_PROPERTY);
    }

    public boolean addRooms(Room room) {
        boolean added = rooms.add(room);
        fireChange(ROOMS_PROPERTY, false, added);
        return added;
    }

    public boolean removeRooms(Room room) {
        boolean removed = rooms.remove(room);
        fireChange(ROOMS_PROPERTY, false, removed);
        return removed;
    }
    
    @Override
    public boolean isEmpty() {
        return containers.isEmpty() && containerSets.isEmpty() && rooms.isEmpty();
    }
}
