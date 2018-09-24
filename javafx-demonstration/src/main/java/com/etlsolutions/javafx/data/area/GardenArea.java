package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubarea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class GardenArea extends Area {

    @JsonIgnore
    public static final String PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.PLANT_BEDS_PROPERTY";
    @JsonIgnore
    public static final String RAISED_PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.RAISED_PLANT_BEDS_PROPERTY";
    @JsonIgnore
    public static final String BORDERS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.BORDERS_PROPERTY";
    @JsonIgnore
    public static final String GREENHOUSES_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.GREENHOUSES_PROPERTY";
    @JsonIgnore
    public static final String CONTAINERS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.CONTAINERS_PROPERTY";
    @JsonIgnore
    public static final String CONTAINER_SETS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.CONTAINER_SETS_PROPERTY";
    @JsonIgnore
    public static final String CUSTOM_SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.GardenArea.CUSTOM_SUBAREAS_PROPERTY";


    private List<PlantBed> plantBeds;
    private List<RaisedPlantBed> raisedPlantBeds;
    private List<Border> borders;
    private List<Greenhouse> greenhouses;
    private List<Container> containers;
    private List<ContainerSet> containerSets;
    private List<CustomSubarea> customSubareas;

    public List<PlantBed> getPlantBeds() {
        return new ArrayList<>(plantBeds);
    }

    public void setPlantBeds(List<PlantBed> plantBeds) {
        this.plantBeds = new ArrayList<>(plantBeds);
        fireChange(PLANT_BEDS_PROPERTY);
    }

    public boolean addPlantBed(PlantBed plantBed) {
        boolean added = plantBeds.add(plantBed);
        fireChange(PLANT_BEDS_PROPERTY, false, added);
        return added;
    }

    public boolean removePlantBed(PlantBed plantBed) {
        boolean removed = plantBeds.remove(plantBed);
        fireChange(PLANT_BEDS_PROPERTY, false, removed);
        return removed;
    }

    public List<Border> getBorders() {
        return new ArrayList<>(borders);
    }

    public void setBorders(List<Border> borders) {
        this.borders = new ArrayList<>(borders);
        fireChange(BORDERS_PROPERTY);
    }

    public boolean addBorders(Border border) {
        boolean added = borders.add(border);
        fireChange(BORDERS_PROPERTY, false, added);
        return added;
    }

    public boolean removeBorders(Border border) {
        boolean removed = borders.remove(border);
        fireChange(BORDERS_PROPERTY, false, removed);
        return removed;
    }

    public List<Greenhouse> getGreenhouses() {
        return new ArrayList<>(greenhouses);
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

    public List<CustomSubarea> getSubareas() {
        return new ArrayList<>(customSubareas);
    }

    public void setSubareas(List<CustomSubarea> subareas) {
        this.customSubareas = new ArrayList<>(subareas);
        fireChange(CUSTOM_SUBAREAS_PROPERTY);
    }

    public boolean addSubarea(CustomSubarea subarea) {
        boolean added = customSubareas.add(subarea);
        fireChange(CUSTOM_SUBAREAS_PROPERTY, false, added);
        return added;
    }

    public boolean removeSubarea(CustomSubarea subarea) {
        boolean removed = customSubareas.remove(subarea);
        fireChange(CUSTOM_SUBAREAS_PROPERTY, false, removed);
        return removed;
    }

    @Override
    public boolean isEmpty() {
        return greenhouses.isEmpty() && plantBeds.isEmpty() && raisedPlantBeds.isEmpty() && borders.isEmpty() && containers.isEmpty() && containerSets.isEmpty() && raisedPlantBeds.isEmpty() && customSubareas.isEmpty();
    }
}
