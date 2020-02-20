package com.etlsolutions.javafx.data.area;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import static com.etlsolutions.javafx.data.area.AreaType.ALLOTMENT;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 * The AllotmentArea class represents an allotment.
 *
 * @author zc
 */
public class AllotmentArea extends Area {

    private ObservableListWrapperA<PlantBed> plantBeds;
    private ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private ObservableListWrapperA<Border> borders;
    private ObservableListWrapperA<Greenhouse> greenhouses;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public AllotmentArea() {
    }

    public AllotmentArea(AreaValueWrapper areaValueWrapper, ObservableListWrapperA<SubArea> subAreas, MeasurementValueWrapper measurementValueWrapper) {

        super(areaValueWrapper, measurementValueWrapper, subAreas);
//        plantBeds = subAreasWr.getPlantBeds();
//        raisedPlantBeds = subAreasWr.getRaisedPlantBeds();
//        borders = subAreasWr.getBorders();
//        greenhouses = subAreasWr.getGreenhouses();
//        customSubareas = subAreasWr.getCustomSubareas();
    }

    public ObservableListWrapperA<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public void setPlantBeds(ObservableListWrapperA<PlantBed> plantBeds) {
        this.plantBeds = plantBeds;
    }

    public ObservableListWrapperA<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public void setRaisedPlantBeds(ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds) {
        this.raisedPlantBeds = raisedPlantBeds;
    }

    public ObservableListWrapperA<Border> getBorders() {
        return borders;
    }

    public void setBorders(ObservableListWrapperA<Border> borders) {
        this.borders = borders;
    }

    public ObservableListWrapperA<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public void setGreenhouses(ObservableListWrapperA<Greenhouse> greenhouses) {
        this.greenhouses = greenhouses;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    public void setCustomSubareas(ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.customSubareas = customSubareas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type) {

        ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case PLANT_BED:
                subAreas.addAll(plantBeds);
                break;
            case RAISED_PLANT_BED:
                subAreas.addAll(raisedPlantBeds);
                break;

            case BORDER:
                subAreas.addAll(borders);
                break;

            case GREEN_HOUSE:
                subAreas.addAll(greenhouses);
                break;

            case CUSTOM:
                subAreas.addAll(plantBeds);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return ALLOTMENT;
    }

    @Override
    public ObservableListWrapperA<SubArea> getAllSubAreas() {

        ObservableListWrapperA<SubArea> sas = new ObservableListWrapperA<>();
        sas.addAll(plantBeds);
        sas.addAll(raisedPlantBeds);
        sas.addAll(borders);
        sas.addAll(greenhouses);
        sas.addAll(customSubareas);
        return sas;
    }

    @Override
    public void remove(SubArea subArea) {
        getSubAreas().remove(subArea);
    }
}
