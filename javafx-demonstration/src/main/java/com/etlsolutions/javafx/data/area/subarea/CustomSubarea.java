package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class CustomSubarea extends Subarea {

    @JsonIgnore
    public static final String LOCATIONS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Custom.LOCATIONS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Custom.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.Custom.CONTAINER_SETS_PROPERTY";

    private List<CustomLocation> locations;
    private List<Container> containers;
    private List<ContainerSet> containerSets;

    public List<CustomLocation> getLocations() {
        return new ArrayList<>(locations);
    }

    public void setLocations(List<CustomLocation> locations) {
        this.locations = new ArrayList<>(locations);
        fireChange(LOCATIONS_PROPERTY);
    }

    public boolean addLocations(CustomLocation location) {
        boolean added = locations.add(location);
        fireChange(LOCATIONS_PROPERTY, false, added);
        return added;
    }

    public boolean removeLocations(CustomLocation location) {
        boolean removed = locations.remove(location);
        fireChange(LOCATIONS_PROPERTY, false, removed);
        return removed;
    }
    
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
    public boolean isEmpty() {
        return locations.isEmpty() && containers.isEmpty() && containerSets.isEmpty();
    }
}
