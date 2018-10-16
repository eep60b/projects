package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private List<ContainerSet> containerSets;

    
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

    @Override
    public void updateAllLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubAreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ObservableList<LocationType> getLocationTypes() {
        return FXCollections.observableArrayList(LocationType.CONTAINER);
    }  
}
