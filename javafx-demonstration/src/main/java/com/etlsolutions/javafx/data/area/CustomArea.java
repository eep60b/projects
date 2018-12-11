package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.Border;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Greenhouse;
import com.etlsolutions.javafx.data.area.subarea.Lawn;
import com.etlsolutions.javafx.data.area.subarea.PlantBed;
import com.etlsolutions.javafx.data.area.subarea.Pond;
import com.etlsolutions.javafx.data.area.subarea.RaisedPlantBed;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

/**
 *
 * @author zc
 */
public class CustomArea extends Area {

    private ObservableListWrapperA<PlantBed> plantBeds;
    private ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private ObservableListWrapperA<Lawn> lawns;
    private ObservableListWrapperA<Border> borders;
    private ObservableListWrapperA<Greenhouse> greenhouses;
    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<Pond> ponds;
    private ObservableListWrapperA<Room> rooms;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public CustomArea() {
    }

    public CustomArea(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, SubAreaListValueWrapper customAreaValueWrapper, MeasurementValueWrapper measurementValueWrapper) {
        
        super(valueWrapper, areaValueWrapper, measurementValueWrapper);
        plantBeds = new ObservableListWrapperA<>(customAreaValueWrapper.getPlantBeds());
        raisedPlantBeds = new ObservableListWrapperA<>(customAreaValueWrapper.getRaisedPlantBeds());
        lawns = new ObservableListWrapperA<>(customAreaValueWrapper.getLawns());
        borders = new ObservableListWrapperA<>(customAreaValueWrapper.getBorders());
        greenhouses = new ObservableListWrapperA<>(customAreaValueWrapper.getGreenhouses());
        containerSets = new ObservableListWrapperA<>(customAreaValueWrapper.getContainerSets());
        singleContainers = new ObservableListWrapperA<>(customAreaValueWrapper.getSingleContainers());
        ponds = new ObservableListWrapperA<>(customAreaValueWrapper.getPonds());
        rooms = new ObservableListWrapperA<>(customAreaValueWrapper.getRooms());
        customSubareas = new ObservableListWrapperA<>(customAreaValueWrapper.getCustomSubareas());
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

    public ObservableListWrapperA<Room> getRooms() {
        return rooms;
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
        allSubAreas.addAll(rooms);
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

            case ROOM:
                subAreas.addAll(rooms);
                break;

            case CUSTOM:
                subAreas.addAll(customSubareas);
                break;
        }
        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.CUSTOM;
    }

    @Override
    public void remove(SubArea selectedSubArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
