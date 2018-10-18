package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PlantBed extends SubArea {

    private ObservableList<PlantBedLocation> locations;

    public PlantBed() {
    }

    public PlantBed(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public PlantBed(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public ObservableList<PlantBedLocation> getLocations() {
        return locations;
    }

    @Override
    public void updateAllLocations() {
        allLocations.clear();
        allLocations.addAll(locations);
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.PLANT_BED;
    }
}
