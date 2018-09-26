package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
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

}
