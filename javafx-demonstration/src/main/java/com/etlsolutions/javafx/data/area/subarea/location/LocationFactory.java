package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;

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

        defaultLocationDirections = new ObservableListWrapperA<>(new String[]{"North", "East", "South", "West", "North east", "North west", "South east", "South west"});

        LocationValueWrapper locationValueWrapper = new LocationValueWrapper("Untitled", "", new ObservableListWrapperA<ImageLink>(), null, "", LocationType.PLANT_BED_LOCATION, 0, 0);
        defaultLocation = new PlantBedLocation(locationValueWrapper, new GroundLocationMeasurement());

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

    public Location createLocation(LocationValueWrapper locationValueWrapper, LocationSpecialValueWrapper locationSpecialValueWrapper) {
        switch (locationValueWrapper.getTypeValueWrapper().getValue()) {
            case BORDER_LOCATION:
                return new BorderLocation(locationValueWrapper, (GroundLocationMeasurement) locationSpecialValueWrapper.getMeasurement());
            case CUSTOMER_LOCATION:
                return new CustomLocation(locationValueWrapper);
            case CONTAINER:
                return new Container(locationValueWrapper, (ContainerMeasurement) locationSpecialValueWrapper.getMeasurement());
            case GREEN_HOUSE_GROUND_LOCATION:
                return new GreenHouseGroundLocation(locationValueWrapper, (GroundLocationMeasurement) locationSpecialValueWrapper.getMeasurement());
            case LAWN_LOCATION:
            case PLANT_BED_LOCATION:
                return new PlantBedLocation(locationValueWrapper, (GroundLocationMeasurement) locationSpecialValueWrapper.getMeasurement());
            case POND_LOCATION:
                return new PondLocation(locationValueWrapper, (GroundLocationMeasurement) locationSpecialValueWrapper.getMeasurement());
            default:
                throw new IllegalArgumentException("Invalid type.");
        }
    }

    public ObservableListWrapperA<String> getDefaultLocationReferencePoints() {
        return defaultLocationReferencePoints;
    }

    public ObservableListWrapperA<String> getDefaultLocationDirections() {
        return defaultLocationDirections;
    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public ObservableListWrapperA<String> getDefaultContainerShape() {
        return defaultContainerShape;
    }

    public Location createLocation(LocationType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
