package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.CustomSubAreaK;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class FarmArea extends Area {
    
    private final ObservableList<PlantBed> plantBeds;
    private final ObservableList<Border> borders;
    private final ObservableList<CustomSubAreaK> customSubareas;

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
