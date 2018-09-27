package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class IndoorArea extends Area {

    private final ObservableList<ContainerSet> containerSets;
    private final ObservableList<SingleContainer> singleContainers;
    private final ObservableList<Room> rooms;

    public IndoorArea() {
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
        return FXCollections.observableArrayList(SubAreaType.BORDER, SubAreaType.CUSTOM);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
