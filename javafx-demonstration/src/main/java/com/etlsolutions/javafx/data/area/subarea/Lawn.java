package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Lawn extends SubArea {

    private ObservableListWrapperA<CustomLocation> customLocations;

    public Lawn() {
    }

    public Lawn(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        customLocations = new ObservableListWrapperA<>();
    }

    public Lawn(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        customLocations = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<CustomLocation> getCustomLocations() {
        return customLocations;
    }

    
    @Override
    public void updateAllLocations() {
        allLocations.clear();
        allLocations.addAll(customLocations);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.LAWN;
    }
}
