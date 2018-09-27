package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PatioArea extends Area {

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

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(SubAreaType.BORDER, SubAreaType.CUSTOM);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
