package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;

/**
 *
 * @author Zhipeng
 */
public class IndoorAreaValueWrapper implements AreaSpecialValueWrapper {

    private final ObservableListWrapperA<ContainerSet> containerSets;
    private final ObservableListWrapperA<SingleContainer> singleContainers;
    private final ObservableListWrapperA<Room> rooms;
    private final ObservableListWrapperA<CustomSubArea> customSubareas;

    public IndoorAreaValueWrapper() {
        this.containerSets = new ObservableListWrapperA<>();
        this.singleContainers = new ObservableListWrapperA<>();
        this.rooms = new ObservableListWrapperA<>();
        this.customSubareas = new ObservableListWrapperA<>();
    }    
    
    public IndoorAreaValueWrapper(ObservableListWrapperA<ContainerSet> containerSets, ObservableListWrapperA<SingleContainer> singleContainers, ObservableListWrapperA<Room> rooms, ObservableListWrapperA<CustomSubArea> customSubareas) {
        this.containerSets = new ObservableListWrapperA<>(containerSets);
        this.singleContainers = new ObservableListWrapperA<>(singleContainers);
        this.rooms = new ObservableListWrapperA<>(rooms);
        this.customSubareas = new ObservableListWrapperA<>(customSubareas);
    }

    public IndoorAreaValueWrapper(IndoorArea area) {
        this(area.getContainerSets(), area.getSingleContainers(), area.getRooms(), area.getCustomSubareas());
    }
    
    public ObservableListWrapperA<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableListWrapperA<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableListWrapperA<Room> getRooms() {
        return rooms;
    }

    public ObservableListWrapperA<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public AreaType getType() {
        return AreaType.INDOOR;
    }
}
