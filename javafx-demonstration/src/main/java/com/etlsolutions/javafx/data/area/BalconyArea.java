package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class BalconyArea extends Area {

    private ObservableList<ContainerSet> containerSets;
    private ObservableList<SingleContainer> singleContainers;

    public BalconyArea() {
    }

    protected BalconyArea(String title, String information) {
        super(title, information);
    }

    public ObservableList<ContainerSet> getContainerSets() {
        return containerSets;
    }

    public ObservableList<SingleContainer> getSingleContainers() {
        return singleContainers;
    }

    @Override
    public void updateAllSubAreas() {
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
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
