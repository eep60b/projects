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
    
    private final ObservableListWrapperA<String> defaultLocationReferencePoints;
    private final ObservableListWrapperA<String> defaultLocationDirections;
    private final ObservableListWrapperA<String> defaultContainerShape;

    private LocationFactory() {
        
        defaultLocationReferencePoints = new ObservableListWrapperA<>(new String[]{"Central", "Northeast corner", "Northwest corner", "Southeast corner", "Southwest corner"});
        
        defaultLocationDirections = new ObservableListWrapperA<>(new String[]{"North", "East", "South", "West",  "North east", "North west", "South east", "South west"});
               
        defaultLocation = new PlantBedLocation("Untitled", "", new ObservableListWrapperA<ImageLink>(), 0, "", 
                new LocationReferencePoint(defaultLocationReferencePoints.get(0)), new LocationDirection(defaultLocationDirections.get(0)), 0, 0);
        
        defaultContainerShape = new ObservableListWrapperA<>(new String[]{"Round", "Square", "Rectangle", "Irregular"});
               
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
    
    public ObservableListWrapperA<String> getDefaultLocationReferencePoints() {
        return defaultLocationReferencePoints;
    }
    
    public ObservableListWrapperA<String> getDefaultLocationDirections(){
        return defaultLocationDirections;
    }
    
    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public ObservableListWrapperA<String> getDefaultContainerShape() {
        return defaultContainerShape;
    }
    
}
