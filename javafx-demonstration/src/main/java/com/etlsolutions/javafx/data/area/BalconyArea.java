package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.BalconyArea.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.BalconyArea.CONTAINER_SETS_PROPERTY";

    private final ObservableList<ContainerSet> containerSets;
    private final ObservableList<SingleContainer> singleContainers;

    public BalconyArea() {
        containerSets = FXCollections.observableArrayList();
        singleContainers = FXCollections.observableArrayList();
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
    }

}
