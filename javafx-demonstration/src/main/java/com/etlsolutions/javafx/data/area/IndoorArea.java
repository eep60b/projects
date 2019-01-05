package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public class IndoorArea extends Area {

    private ObservableListWrapperA<ContainerSet> containerSets;
    private ObservableListWrapperA<SingleContainer> singleContainers;
    private ObservableListWrapperA<Room> rooms;
    private ObservableListWrapperA<CustomSubArea> customSubareas;

    public IndoorArea() {
    }

    public IndoorArea(AreaValueWrapper areaValueWrapper, ObservableListWrapperA<SubArea> subAreas, MeasurementValueWrapper measurementValueWrapper) {
        super(areaValueWrapper, measurementValueWrapper, subAreas);
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
    public ObservableListWrapperA<SubArea> getAllSubAreas() {

        ObservableListWrapperA<SubArea> allSubAreas = new ObservableListWrapperA<>();
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(rooms);
        allSubAreas.addAll(customSubareas);
        
        return allSubAreas;
    }

    @Override
    public ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type) {

        ObservableListWrapperA<SubArea> subAreas = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINTER_SET:
                subAreas.addAll(containerSets);
                break;
            case SINGLE_CONTAINTER:
                subAreas.addAll(singleContainers);
                break;
            case ROOM:
                subAreas.addAll(rooms);
                break;
            case CUSTOM:
                subAreas.addAll(customSubareas);
        }

        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.INDOOR;
    }

    @Override
    public void remove(SubArea selectedSubArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
