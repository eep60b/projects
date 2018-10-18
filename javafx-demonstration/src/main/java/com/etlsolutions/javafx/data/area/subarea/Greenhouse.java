package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Container;
import com.etlsolutions.javafx.data.area.subarea.location.GreenHouseGroundLocation;
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

    public Greenhouse(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
        containers = new ObservableListWrapperA<>();
    }

    public Greenhouse(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
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
    public void updateAllLocations() {
        allLocations.addAll(locations);
        allLocations.addAll(containers);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.GREEN_HOUSE;
    }
}
