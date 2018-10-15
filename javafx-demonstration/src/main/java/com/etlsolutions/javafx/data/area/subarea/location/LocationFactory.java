package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class LocationFactory {

    private static final LocationFactory INSTANCE = new LocationFactory();

    private final Location defaultLocation;
    
    private final ObservableList<LocationReferencePoint> defaultLocationReferencePoints;
    private final ObservableList<LocationDirection> defaultLocationDirections;

    private LocationFactory() {
        
        defaultLocationReferencePoints = new ObservableListWrapperA<>();
        String[] referencePointTitles = {"Central", "Northeast corner", "Northwest corner", "Southeast corner", "Southwest corner"};
        
        for(String title : referencePointTitles) {
            defaultLocationReferencePoints.add(new LocationReferencePoint(title));
        }
        
        defaultLocationDirections = new ObservableListWrapperA<>();
        
        String[] directionTitles = {"North", "East", "South", "West",  "North east", "North west", "South east", "South west"};
        
        for(String title : directionTitles) {
            defaultLocationDirections.add(new LocationDirection(title));
        }
        
        defaultLocation = new Location();
    }

    public static LocationFactory getInstance() {
        return INSTANCE;
    }

    public BorderLocation createBorderLocation() {

        BorderLocation l = new BorderLocation();

        return l;
    }

    public Container createContainer() {
        Container c = new Container();

        return c;
    }
    
    public PlantBedLocation createPlantBedLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        return new PlantBedLocation(title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }
    
    public ObservableList<LocationReferencePoint> getDefaultLocationReferencePoints() {
        return defaultLocationReferencePoints;
    }
    
    public ObservableList<LocationDirection> getDefaultLocationDirections(){
        return defaultLocationDirections;
    }
}
