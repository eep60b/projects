package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.Lawn;
import com.etlsolutions.javafx.data.area.subarea.Pond;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public class GardenArea extends Area {

    private ObservableListWrapperA<PlantBed> plantBeds;
    private ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private ObservableListWrapperA<Lawn> lawns;
    private ObservableListWrapperA<Border> borders;
    private ObservableListWrapperA<Greenhouse> greenhouses;
    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<Pond> ponds;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public GardenArea() {

    }

    public GardenArea(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, GardenAreaValueWrapper gardenAreaValueWrapper, MeasurementValueWrapper measurementValueWrapper) {
        super(valueWrapper, areaValueWrapper, measurementValueWrapper);
        plantBeds = new ObservableListWrapperA<>(gardenAreaValueWrapper.getPlantBeds());
        raisedPlantBeds = new ObservableListWrapperA<>(gardenAreaValueWrapper.getRaisedPlantBeds());
        lawns = new ObservableListWrapperA<>(gardenAreaValueWrapper.getLawns());
        borders = new ObservableListWrapperA<>(gardenAreaValueWrapper.getBorders());
        greenhouses = new ObservableListWrapperA<>(gardenAreaValueWrapper.getGreenhouses());
        containerSets = new ObservableListWrapperA<>(gardenAreaValueWrapper.getContainerSets());
        singleContainers = new ObservableListWrapperA<>(gardenAreaValueWrapper.getSingleContainers());
        ponds = new ObservableListWrapperA<>(gardenAreaValueWrapper.getPonds());
        customSubareas = new ObservableListWrapperA<>(gardenAreaValueWrapper.getCustomSubareas());
    }

    public ObservableListWrapperA<PlantBed> getPlantBeds() {
        return plantBeds;
    }

    public ObservableListWrapperA<RaisedPlantBed> getRaisedPlantBeds() {
        return raisedPlantBeds;
    }

    public ObservableListWrapperA<Lawn> getLawns() {
        return lawns;
    }

    public ObservableListWrapperA<Border> getBorders() {
        return borders;
    }

    public ObservableListWrapperA<Greenhouse> getGreenhouses() {
        return greenhouses;
    }

    public ObservableListWrapperA<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableListWrapperA<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableListWrapperA<Pond> getPonds() {
        return ponds;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getAllSubAreas() {
        
        ObservableListWrapperA<SubArea> allSubAreas = new ObservableListWrapperA<>();
        allSubAreas.addAll(plantBeds);
        allSubAreas.addAll(raisedPlantBeds);
        allSubAreas.addAll(lawns);
        allSubAreas.addAll(borders);
        allSubAreas.addAll(greenhouses);
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(ponds);
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
            case RAISED_PLANT_BED:
                subAreas.addAll(raisedPlantBeds);
                break;
            case LAWN:
                subAreas.addAll(lawns);
                break;

            case BORDER:
                subAreas.addAll(borders);
                break;

            case GREEN_HOUSE:
                subAreas.addAll(greenhouses);
                break;

            case CONTAINTER_SET:
                subAreas.addAll(containerSets);
                break;

            case SINGLE_CONTAINTER:
                subAreas.addAll(singleContainers);
                break;
            case POND:
                subAreas.addAll(ponds);
                break;

            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.GARDEN;
    }
}
