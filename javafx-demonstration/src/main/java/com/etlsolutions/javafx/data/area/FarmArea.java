package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.PlantBedBorder;
import com.etlsolutions.javafx.data.area.subarea.Subarea;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public class FarmArea extends Area {

    @JsonIgnore
    public static final String PLANT_BEDS_PROPERTY = "com.etlsolutions.javafx.data.area.FarmArea.PLANT_BEDS_PROPERTY";
    @JsonIgnore
    public static final String BORDERS_PROPERTY = "com.etlsolutions.javafx.data.area.FarmArea.BORDERS_PROPERTY";
    @JsonIgnore
    public static final String SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.FarmArea.SUBAREAS_PROPERTY";
    
    private List<PlantBed> plantBeds;
    private List<PlantBedBorder> borders;
    private List<Subarea> subareas;
    
    public List<PlantBed> getPlantBeds() {
        return new ArrayList<>(plantBeds);
    }

    public void setPlantBeds(List<PlantBed> plantBeds) {
        this.plantBeds =new ArrayList<>(plantBeds);
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

    public List<PlantBedBorder> getBorders() {
        return new ArrayList<>(borders);
    }

    public void setBorders(List<PlantBedBorder> borders) {
        this.borders = new ArrayList<>(borders);
        fireChange(BORDERS_PROPERTY);
    }

    public boolean addBorders(PlantBedBorder border) {
        boolean added = borders.add(border);
        fireChange(BORDERS_PROPERTY, false, added);
        return added;
    }

    public boolean removeBorders(PlantBedBorder border) {
        boolean removed = borders.remove(border);
        fireChange(BORDERS_PROPERTY, false, removed);
        return removed;
    }

    public List<Subarea> getSubareas() {
        return new ArrayList<>(subareas);
    }

    public void setSubareas(List<Subarea> subareas) {
        this.subareas = new ArrayList<>(subareas);
        fireChange(SUBAREAS_PROPERTY);
    }

    public boolean addSubarea(Subarea subarea) {
        boolean added = subareas.add(subarea);
        fireChange(SUBAREAS_PROPERTY, false, added);
        return added;
    }

    public boolean removeSubarea(Subarea subarea) {
        boolean removed = subareas.remove(subarea);
        fireChange(SUBAREAS_PROPERTY, false, removed);
        return removed;
    }
   
    @Override
    public boolean isEmpty() {
        return plantBeds.isEmpty() && borders.isEmpty() && subareas.isEmpty();
    }
}
