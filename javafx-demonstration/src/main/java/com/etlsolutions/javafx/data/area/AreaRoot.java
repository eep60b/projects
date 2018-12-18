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

    private ObservableListWrapperA<Area> areas;

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
        areas = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<GardenArea> getGardenAreas() {
        return gardenAreas;
    }

    public void setGardenAreas(ObservableListWrapperA<GardenArea> gardenAreas) {
        this.gardenAreas = gardenAreas;
    }

    public ObservableListWrapperA<IndoorArea> getIndoorAreas() {
        return indoorAreas;
    }

    public void setIndoorAreas(ObservableListWrapperA<IndoorArea> indoorAreas) {
        this.indoorAreas = indoorAreas;
    }

    public ObservableListWrapperA<PatioArea> getPatioAreas() {
        return patioAreas;
    }

    public void setPatioAreas(ObservableListWrapperA<PatioArea> patioAreas) {
        this.patioAreas = patioAreas;
    }

    public ObservableListWrapperA<BalconyArea> getBalconyAreas() {
        return balconyAreas;
    }

    public void setBalconyAreas(ObservableListWrapperA<BalconyArea> balconyAreas) {
        this.balconyAreas = balconyAreas;
    }

    public ObservableListWrapperA<AllotmentArea> getAllotmentAreas() {
        return allotmentAreas;
    }

    public void setAllotmentAreas(ObservableListWrapperA<AllotmentArea> allotmentAreas) {
        this.allotmentAreas = allotmentAreas;
    }

    public ObservableListWrapperA<FarmArea> getFarmAreas() {
        return farmAreas;
    }

    public void setFarmAreas(ObservableListWrapperA<FarmArea> farmAreas) {
        this.farmAreas = farmAreas;
    }

    public ObservableListWrapperA<CustomArea> getCustomAreas() {
        return customAreas;
    }

    public void setCustomAreas(ObservableListWrapperA<CustomArea> customAreas) {
        this.customAreas = customAreas;
    }

    public ObservableListWrapperA<Area> getAllAreas() {

        ObservableListWrapperA<Area> allAreas = new ObservableListWrapperA<>();
        allAreas.addAll(gardenAreas);
        allAreas.addAll(indoorAreas);
        allAreas.addAll(patioAreas);
        allAreas.addAll(balconyAreas);
        allAreas.addAll(allotmentAreas);
        allAreas.addAll(farmAreas);
        allAreas.addAll(customAreas);
        return allAreas;
    }

    public ObservableListWrapperA<Area> getAreas() {
        return areas;
    }

    public void setAreas(ObservableListWrapperA<Area> areas) {
        this.areas = areas;
    }

    public void remove(Area area) {

        areas.remove(area);
//        switch (area.getType()) {
//            case ALLOTMENT:                
//                allotmentAreas.remove((AllotmentArea) area);
//            case BALCONY:
//                balconyAreas.remove((BalconyArea) area);
//            case CUSTOM:
//                customAreas.remove((CustomArea) area);
//            case FARM:
//                farmAreas.remove((FarmArea) area);
//            case GARDEN:
//                gardenAreas.remove((GardenArea) area);
//            case INDOOR:
//                indoorAreas.remove((IndoorArea) area);
//            case PATIO:
//                patioAreas.remove((PatioArea) area);
//        }
    }

    public void add(Area area) {
        areas.add(area);
    }

}
