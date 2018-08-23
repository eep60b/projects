package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.BalconyArea.CONTAINERS_PROPERTY";
    
    private List<Container> containers;

    public List<Container> getContainers() {
        return new ArrayList<>(containers);
    }

    public void setContainers(List<Container> containers) {
        this.containers = new ArrayList<>(containers);
        fireChange(CONTAINERS_PROPERTY);
    }
    
    public boolean addContainer(Container container) {
        boolean added =containers.add(container);
        fireChange(CONTAINERS_PROPERTY, false, added);
        return added;
    }
    
    public boolean removeContainer(Container container) {
        boolean removed =containers.remove(container);
        fireChange(CONTAINERS_PROPERTY, false, removed);
        return removed;
    }
    
    @Override
    public boolean isEmpty() {
        return containers.isEmpty();
    }
}
