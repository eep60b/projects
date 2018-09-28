package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class IndoorArea extends Area {

    private ObservableList<ContainerSet> containerSets;
    private ObservableList<SingleContainer> singleContainers;
    private ObservableList<Room> rooms;

    public IndoorArea() {
    }

    public IndoorArea(String title, String information) {
        super(title, information);
        containerSets = FXCollections.observableArrayList();
        singleContainers = FXCollections.observableArrayList();
        rooms = FXCollections.observableArrayList();
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    @Override
    public void updateAllSubAreas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<SubAreaType> getSubAreaTypes() {
        return FXCollections.observableArrayList(CONTAINTER_SET, SINGLE_CONTAINTER);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {

        ObservableList<SubArea> subAreas = FXCollections.observableArrayList();
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
        }

        return subAreas;
    }

    @Override
    public AreaType getType() {
        return AreaType.INDOOR;
    }
}
