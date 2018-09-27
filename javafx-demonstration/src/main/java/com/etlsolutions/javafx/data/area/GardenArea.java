package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubAreaK;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.Lawn;
import com.etlsolutions.javafx.data.area.subarea.Pond;
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
public class GardenArea extends Area {

    private final ObservableList<PlantBed> plantBeds;
    private final ObservableList<RaisedPlantBed> raisedPlantBeds;
    private final ObservableList<Lawn> lawns;
    private final ObservableList<Border> borders;
    private final ObservableList<Greenhouse> greenhouses;
    private final ObservableList<ContainerSet> containerSets;
    private final ObservableList<SingleContainer> singleContainers;
    private final ObservableList<Pond> ponds;
    private final ObservableList<CustomSubAreaK> customSubareas;

    public GardenArea() {
        plantBeds = FXCollections.observableArrayList();
        raisedPlantBeds = FXCollections.observableArrayList();
        lawns = FXCollections.observableArrayList();
        borders = FXCollections.observableArrayList();
        greenhouses = FXCollections.observableArrayList();
        containerSets = FXCollections.observableArrayList();
        singleContainers = FXCollections.observableArrayList();
        ponds = FXCollections.observableArrayList();
        customSubareas = FXCollections.observableArrayList();
    }

    public ObservableList<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableList<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableList<Lawn> getLawns() {
        return lawns;
    }

    public ObservableList<Border> getBorders() {
        return borders;
    }

    public ObservableList<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<Pond> getPonds() {
        return ponds;
    }

    public ObservableList<CustomSubAreaK> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(lawns);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(ponds);
        allSubAreas.addAll(customSubareas);
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
