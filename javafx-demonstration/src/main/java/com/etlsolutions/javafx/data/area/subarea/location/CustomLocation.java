package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class CustomLocation extends Location {

    public CustomLocation() {
    }

    public CustomLocation(LocationValueWrapper locationValueWrapper) {
        super(locationValueWrapper);
    }

    @Override
    public LocationType getType() {
        return LocationType.CUSTOMER_LOCATION;
    }
}
