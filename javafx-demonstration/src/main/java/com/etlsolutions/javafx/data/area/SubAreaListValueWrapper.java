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
import com.etlsolutions.javafx.data.area.subarea.SubArea;

/**
 *
 * @author Zhipeng
 */
public class SubAreaListValueWrapper {

    private final ObservableListWrapperA<PlantBed> plantBeds = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<RaisedPlantBed> raisedPlantBeds = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<Lawn> lawns = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<Border> borders = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<Greenhouse> greenhouses = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<ContainerSet> containerSets = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<SingleContainer> singleContainers = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<Pond> ponds = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<Room> rooms = new ObservableListWrapperA<>();
    private final ObservableListWrapperA<CustomSubArea> customSubareas = new ObservableListWrapperA<>();

    public SubAreaListValueWrapper() {
    }
    
    public SubAreaListValueWrapper(ObservableListWrapperA<SubArea> subAreas) {
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
                case CONTAINTER_SET:
                    containerSets.add((ContainerSet) subArea);
                case LAWN:
                    lawns.add((Lawn) subArea);
                case POND:
                    ponds.add((Pond) subArea);
                case ROOM:
                    rooms.add((Room) subArea);
                case SINGLE_CONTAINTER:
                    singleContainers.add((SingleContainer) subArea);
            }
        }
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

}
