package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class ContainerSet extends SubAreaK {

    private final ObservableList<Container> containers;

    public ContainerSet() {
        containers = FXCollections.observableArrayList();
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public void updateAllLocations() {
        allLocations.addAll(containers);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CONTAINTER_SET;
    }

}
