package com.etlsolutions.javafx.data.area;

import static com.etlsolutions.javafx.data.area.BalconyArea.CONTAINER_SETS_PROPERTY;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

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

    private List<RaisedPlantBed> raisedPlantBeds;
    private List<Greenhouse> greenhouses;
    private List<Container> containers;
    private List<ContainerSet> containerSets;

    public List<Greenhouse> getGreenhouses() {
        return new ArrayList<>(greenhouses);
    }
    
    public void setGreenhouses(List<Greenhouse> greenhouses) {
        this.greenhouses = new ArrayList<>(greenhouses);
        fireChange(GREENHOUSES_PROPERTY);
    }
    
    public boolean addGreenhouses(Greenhouse greenhous) {
        boolean added = greenhouses.add(greenhous);
        fireChange(GREENHOUSES_PROPERTY, false, added);
        return added;
    }

    public boolean removeGreenhouses(Greenhouse greenhous) {
        boolean removed = greenhouses.remove(greenhous);
        fireChange(GREENHOUSES_PROPERTY, false, removed);
        return removed;
    }

    public List<RaisedPlantBed> getRaisedPlantBeds() {
        return new ArrayList<>(raisedPlantBeds);
    }

    public void setRaisedPlantBeds(List<RaisedPlantBed> raisedPlantBeds) {
        this.raisedPlantBeds = new ArrayList<>(raisedPlantBeds);
    }
    
    public boolean addRaisedPlantBed(RaisedPlantBed raisedPlantBed) {
        boolean added = raisedPlantBeds.add(raisedPlantBed);
        fireChange(RAISED_PLANT_BEDS_PROPERTY, false, added);
        return added;
    }
    
    public boolean removeRaisedPlantBed(RaisedPlantBed raisedPlantBed) {
        boolean removed = raisedPlantBeds.remove(raisedPlantBed);
        fireChange(RAISED_PLANT_BEDS_PROPERTY, false, removed);
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

    
    @Override
    public boolean isEmpty() {
        return greenhouses.isEmpty() && raisedPlantBeds.isEmpty() && containers.isEmpty() && containerSets.isEmpty();
    }
}
