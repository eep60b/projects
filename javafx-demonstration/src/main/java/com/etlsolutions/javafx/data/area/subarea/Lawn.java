package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.CustomLocation;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public class Lawn extends SubArea {

    private ObservableListWrapperA<CustomLocation> locations;

    public Lawn() {
    }

    public Lawn(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public Lawn(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public ObservableListWrapperA<CustomLocation> getLocations() {
        return locations;
    }

    public void setLocations(ObservableListWrapperA<CustomLocation> locations) {
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
        return SubAreaType.LAWN;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {
            case CUSTOMER_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }
    
        @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.CUSTOMER_LOCATION);
    }
}
