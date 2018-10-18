package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomSubArea extends SubArea {

    private ObservableList<CustomLocation> locations;
    private ObservableList<Container> containers;

    public CustomSubArea() {

    }

    public CustomSubArea(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public CustomSubArea(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public ObservableList<CustomLocation> getLocations() {
        return locations;
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public void updateAllLocations() {
        allLocations.addAll(locations);
        allLocations.addAll(containers);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CUSTOM;
    }
}
