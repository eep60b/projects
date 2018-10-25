package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class AreaRoot extends DataUnit {

    private ObservableListWrapperA<GardenArea> gardenAreas;
    private ObservableListWrapperA<IndoorArea> indoorAreas;
    private ObservableListWrapperA<PatioArea> patioAreas;
    private ObservableListWrapperA<BalconyArea> balconyAreas;
    private ObservableListWrapperA<AllotmentArea> allotmentAreas;
    private ObservableListWrapperA<FarmArea> farmAreas;
    private ObservableListWrapperA<CustomArea> customAreas;
    private ObservableListWrapperA<Area> allAreas;

    public AreaRoot() {

    }

    public AreaRoot(String title, String information) {
        super(title, information);
        gardenAreas = new ObservableListWrapperA<>();
        indoorAreas = new ObservableListWrapperA<>();
        patioAreas = new ObservableListWrapperA<>();
        balconyAreas = new ObservableListWrapperA<>();
        allotmentAreas = new ObservableListWrapperA<>();
        farmAreas = new ObservableListWrapperA<>();
        customAreas = new ObservableListWrapperA<>();
        allAreas = new ObservableListWrapperA<>();
        
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

    public ObservableListWrapperA<GardenArea> getGardenAreas() {
        return gardenAreas;
    }

    public ObservableListWrapperA<IndoorArea> getIndoorAreas() {
        return indoorAreas;
    }

    public ObservableListWrapperA<PatioArea> getPatioAreas() {
        return patioAreas;
    }

    public ObservableListWrapperA<BalconyArea> getBalconyAreas() {
        return balconyAreas;
    }

    public ObservableListWrapperA<AllotmentArea> getAllotmentAreas() {
        return allotmentAreas;
    }

    public ObservableListWrapperA<FarmArea> getFarmAreas() {
        return farmAreas;
    }

    public ObservableListWrapperA<CustomArea> getCustomAreas() {
        return customAreas;
    }

    public ObservableListWrapperA<Area> getAllAreas() {
        return allAreas;
    }

    public void remove(Area selectedArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
