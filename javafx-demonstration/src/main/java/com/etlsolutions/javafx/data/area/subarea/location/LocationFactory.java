package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class LocationFactory {

    private static final LocationFactory INSTANCE = new LocationFactory();

    private final Location defaultLocation;

    private LocationFactory() {
        
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
}
