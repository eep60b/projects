package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.CustomSubarea;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
    private final ObservableList<PlantBed> plantBeds;
    private final ObservableList<Border> borders;
    private final ObservableList<CustomSubarea> customSubareas;

    public FarmArea() {
        plantBeds = FXCollections.observableArrayList();
        borders = FXCollections.observableArrayList();
        customSubareas = FXCollections.observableArrayList();
    }

    public ObservableList<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableList<Border> getBorders() {
        return borders;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(customSubareas);
    }
}
