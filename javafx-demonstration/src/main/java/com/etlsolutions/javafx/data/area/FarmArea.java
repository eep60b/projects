package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.CustomSubarea;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
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
    public static final String CUSTOM_SUBAREAS_PROPERTY = "com.etlsolutions.javafx.data.area.FarmArea.CUSTOM_SUBAREAS_PROPERTY";
    
    private List<PlantBed> plantBeds;
    private List<Border> borders;
    private List<CustomSubarea> customSubareas;
    
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

    public List<CustomSubarea> getCustomSubareas() {
        return new ArrayList<>(customSubareas);
    }

    public void setCustomSubareas(List<CustomSubarea> customSubareas) {
        this.customSubareas = new ArrayList<>(customSubareas);
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
        return plantBeds.isEmpty() && borders.isEmpty() && customSubareas.isEmpty();
    }
}
