package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
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

    public AllotmentArea(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper, ObservableListWrapperA<SubArea> subAreas) {
        super(valueWrapper, areaValueWrapper, measurementValueWrapper);
        plantBeds = new ObservableListWrapperA<>();
        raisedPlantBeds = new ObservableListWrapperA<>();
        borders = new ObservableListWrapperA<>();
        greenhouses = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
        for (SubArea subArea : subAreas) {
            switch (subArea.getType()) {
                case PLANT_BED:
                    plantBeds.add((PlantBed) subArea);
                    break;
                case RAISED_PLANT_BED:
                    raisedPlantBeds.add((RaisedPlantBed) subArea);
                    break;
                case BORDER:
                    borders.add((Border) subArea);
                    break;
                case GREEN_HOUSE:
                    greenhouses.add((Greenhouse) subArea);
                    break;
                case CUSTOM:
                    customSubareas.add((CustomSubArea) subArea);
            }
        }
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
}
