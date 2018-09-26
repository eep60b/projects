package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
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
public class PatioArea extends Area {

    @JsonIgnore
    public static final String RAISED_PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.PatioArea.RAISED_PLANT_BEDS_PROPERTY";
    @JsonIgnore
    public static final String GREENHOUSES_PROPERTY = "com.etlsolutions.javafx.data.area.PatioArea.GREENHOUSES_PROPERTY";
    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.PatioArea.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.PatioArea.CONTAINER_SETS_PROPERTY";

    private final ObservableList<RaisedPlantBed> raisedPlantBeds;
    private final ObservableList<Greenhouse> greenhouses;
    private final ObservableList<SingleContainer> singleContainers;
    private final ObservableList<ContainerSet> containerSets;

    public PatioArea() {
        raisedPlantBeds = FXCollections.observableArrayList();
        greenhouses = FXCollections.observableArrayList();
        singleContainers = FXCollections.observableArrayList();
        containerSets = FXCollections.observableArrayList();
    }

    public ObservableList<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableList<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
    }

}
