package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.ContainerSet;
import com.etlsolutions.javafx.data.area.subarea.CustomSubArea;
import com.etlsolutions.javafx.data.area.subarea.Room;
import com.etlsolutions.javafx.data.area.subarea.SingleContainer;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class IndoorArea extends Area {

    private ObservableList<ContainerSet> containerSets;
    private ObservableList<SingleContainer> singleContainers;
    private ObservableList<Room> rooms;
    private ObservableList<CustomSubArea> customSubareas;

    public IndoorArea() {
    }

    protected IndoorArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, longitude, latitude, measurement, shape);
        containerSets = new ObservableListWrapperA<>();
        singleContainers = new ObservableListWrapperA<>();
        rooms = new ObservableListWrapperA<>();
        customSubareas = new ObservableListWrapperA<>();
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

    public ObservableList<CustomSubArea> getCustomSubareas() {
        return customSubareas;
    }

    @Override
    public void updateAllSubAreas() {

        allSubAreas.clear();
        allSubAreas.addAll(containerSets);
        allSubAreas.addAll(singleContainers);
        allSubAreas.addAll(rooms);
        allSubAreas.addAll(customSubareas);
    }

    @Override
    public ObservableList<SubArea> getSubAreas(SubAreaType type) {

        ObservableList<SubArea> subAreas = new ObservableListWrapperA<>();
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
}
