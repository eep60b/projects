package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
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

/**
 *
 * @author Zhipeng
 */
public class CustomAreaValueWrapper implements AreaSpecialValueWrapper {

    private final ObservableListWrapperA<PlantBed> plantBeds;
    private final ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds;
    private final ObservableListWrapperA<Lawn> lawns;
    private final ObservableListWrapperA<Border> borders;
    private final ObservableListWrapperA<Greenhouse> greenhouses;
    private final ObservableListWrapperA<ContainerSet> containerSets;
    private final ObservableListWrapperA<SingleContainer> singleContainers;
    private final ObservableListWrapperA<Pond> ponds;
    private final ObservableListWrapperA<Room> rooms;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public CustomAreaValueWrapper(ObservableListWrapperA<PlantBed> plantBeds, ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds, ObservableListWrapperA<Lawn> lawns, ObservableListWrapperA<Border> borders, ObservableListWrapperA<Greenhouse> greenhouses, ObservableListWrapperA<ContainerSet> containerSets, ObservableListWrapperA<SingleContainer> singleContainers, ObservableListWrapperA<Pond> ponds, ObservableListWrapperA<Room> rooms, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.plantBeds = new ObservableListWrapperA<>(plantBeds);
        this.raisedPlantBeds = new ObservableListWrapperA<>(raisedPlantBeds);
        this.borders = new ObservableListWrapperA<>(borders);
        this.greenhouses = new ObservableListWrapperA<>(greenhouses);
        this.customSubareas = new ObservableListWrapperA<>(customSubareas);
        this.lawns = new ObservableListWrapperA<>(lawns);
        this.containerSets = new ObservableListWrapperA<>(containerSets);
        this.singleContainers = new ObservableListWrapperA<>(singleContainers);
        this.ponds = new ObservableListWrapperA<>(ponds);
        this.rooms = new ObservableListWrapperA<>(rooms);
    }

    public CustomAreaValueWrapper(CustomArea area) {
        this(area.getPlantBeds(), area.getRaisedPlantBeds(), area.getLawns(), area.getBorders(), area.getGreenhouses(), area.getContainerSets(), area.getSingleContainers(), area.getPonds(), area.getRooms(), area.getCustomSubareas());
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

    public ObservableListWrapperA<Room> getRooms() {
        return rooms;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public AreaType getType() {
        return AreaType.CUSTOM;
    }
}
