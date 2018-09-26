package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class AreaRoot extends DataUnit {

    private final ObservableList<GardenArea> gardenAreas;
    private final ObservableList<IndoorArea> indoorAreas;
    private final ObservableList<PatioArea> patioAreas;
    private final ObservableList<BalconyArea> balconyAreas;
    private final ObservableList<AllotmentArea> allotmentAreas;
    private final ObservableList<FarmArea> farmAreas;
    private final ObservableList<CustomArea> customAreas;
    private final ObservableList<Area> allAreas;

    public AreaRoot() {
        gardenAreas = FXCollections.observableArrayList();
        indoorAreas = FXCollections.observableArrayList();
        patioAreas = FXCollections.observableArrayList();
        balconyAreas = FXCollections.observableArrayList();
        allotmentAreas = FXCollections.observableArrayList();
        farmAreas = FXCollections.observableArrayList();
        customAreas = FXCollections.observableArrayList();
        allAreas = FXCollections.observableArrayList();
        
        updateAllAreas();
    }
    
    private void updateAllAreas() {
        allAreas.clear();
        allAreas.addAll(gardenAreas);
        allAreas.addAll(indoorAreas);
        allAreas.addAll(patioAreas);
        allAreas.addAll(balconyAreas);
        allAreas.addAll(allotmentAreas);
        allAreas.addAll(farmAreas);
        allAreas.addAll(customAreas);
    }

    public ObservableList<GardenArea> getGardenAreas() {
        return gardenAreas;
    }

    public ObservableList<IndoorArea> getIndoorAreas() {
        return indoorAreas;
    }

    public ObservableList<PatioArea> getPatioAreas() {
        return patioAreas;
    }

    public ObservableList<BalconyArea> getBalconyAreas() {
        return balconyAreas;
    }

    public ObservableList<AllotmentArea> getAllotmentAreas() {
        return allotmentAreas;
    }

    public ObservableList<FarmArea> getFarmAreas() {
        return farmAreas;
    }

    public ObservableList<CustomArea> getCustomAreas() {
        return customAreas;
    }

    public ObservableList<Area> getAllAreas() {
        return allAreas;
    }
 
}
