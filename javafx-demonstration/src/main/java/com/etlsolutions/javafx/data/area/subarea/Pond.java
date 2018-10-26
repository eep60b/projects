package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import com.etlsolutions.javafx.data.area.subarea.location.PondLocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Pond extends SubArea {

    private ObservableListWrapperA<PondLocation> locations;

    public Pond() {

    }

    public Pond(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public Pond(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(measurement, shape, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        locations = new ObservableListWrapperA<>();
    }

    public ObservableList<PondLocation> getLocations() {
        return locations;
    }

    @Override
    public ObservableListWrapperA<Location> getAllLocations() {
        ObservableListWrapperA list = new ObservableListWrapperA<>();
        list.addAll(locations);
        return list;
    }

    @Override
    public SubAreaType getType() {
        return SubAreaType.POND;
    }

    @Override
    public ObservableListWrapperA<Location> getLocations(LocationType type) {
        
        ObservableListWrapperA<Location> list = new ObservableListWrapperA<>();
        switch (type) {

            case POND_LOCATION:
                list.addAll(locations);
                break;
        }
        return list;
    }
        @Override
    public ObservableListWrapperA<LocationType> getLocationTypes() {
        return new ObservableListWrapperA<>(LocationType.POND_LOCATION);
    }
    
}
