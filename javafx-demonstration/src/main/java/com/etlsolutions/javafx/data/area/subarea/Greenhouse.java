package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.GreenHouseGroundLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Greenhouse extends SubArea {

    private ObservableList<GreenHouseGroundLocation> locations;
    private ObservableList<Container> containers;

    public Greenhouse() {
    }

    public Greenhouse(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public Greenhouse(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public ObservableList<GreenHouseGroundLocation> getLocations() {
        return locations;
    }

    public ObservableList<Container> getContainers() {
        return containers;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        list.addAll(containers);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.GREEN_HOUSE;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case CONTAINER:
                list.addAll(containers);
                break;
            case GREEN_HOUSE_GROUND_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }

    @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CONTAINER, LocationType.GREEN_HOUSE_GROUND_LOCATION);
    }
}
