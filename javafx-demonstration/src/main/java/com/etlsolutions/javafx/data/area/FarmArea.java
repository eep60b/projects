package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public class FarmArea extends Area {

    private ObservableListWrapperA<PlantBed> plantBeds;
    private ObservableListWrapperA<Border> borders;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public FarmArea() {
    }

    public FarmArea(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, SubAreaListValueWrapper subAreas, MeasurementValueWrapper measurementValueWrapper) {
        super(valueWrapper, areaValueWrapper, measurementValueWrapper);

        plantBeds = new ObservableListWrapperA<>(subAreas.getPlantBeds());
        borders = new ObservableListWrapperA<>(subAreas.getBorders());
        customSubareas = new ObservableListWrapperA<>(subAreas.getCustomSubareas());
    }

    public ObservableListWrapperA<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public void setPlantBeds(ObservableListWrapperA<PlantBed> plantBeds) {
        this.plantBeds = plantBeds;
    }

    public ObservableListWrapperA<Border> getBorders() {
        return borders;
    }

    public void setBorders(ObservableListWrapperA<Border> borders) {
        this.borders = borders;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    public void setCustomSubareas(ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.customSubareas = customSubareas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getAllSubAreas() {

        ObservableListWrapperA<SubArea> allSubAreas = new ObservableListWrapperA<>();

        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(customSubareas);
        return allSubAreas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type) {

        ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case PLANT_BED:
                subAreas.addAll(plantBeds);
                break;
            case BORDER:
                subAreas.addAll(borders);
                break;

            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.FARM;
    }
}
