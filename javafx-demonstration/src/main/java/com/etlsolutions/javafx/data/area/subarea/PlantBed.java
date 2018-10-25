package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
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

    public void setLocations(ObservableList<PlantBedLocation> locations) {
        this.locations = locations;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        return list;
    }
    
    @Override
    public SubAreaType getType() {
        return SubAreaType.PLANT_BED;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case PLANT_BED_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }
}
