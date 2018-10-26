package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomSubArea extends SubArea {

    private ObservableList<CustomLocation> customlocations;
    private ObservableList<Container> containers;

    public CustomSubArea() {

    }

    public CustomSubArea(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        customlocations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public CustomSubArea(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        customlocations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public ObservableList<CustomLocation> getCustomlocations() {
        return customlocations;
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(customlocations);
        list.addAll(containers);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.CUSTOM;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {

        ObservableListWrapperA<Location> locations = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINER:
                locations.addAll(containers);
                break;
            case CUSTOMER_LOCATION:
                locations.addAll(customlocations);
                break;
        }
        return locations;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CUSTOMER_LOCATION);
    }
}
