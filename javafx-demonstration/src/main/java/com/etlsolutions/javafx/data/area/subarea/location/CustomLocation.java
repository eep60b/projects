package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class CustomLocation extends Location {

    public CustomLocation() {
    }

    public CustomLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper);
    }

    @Override
    public LocationType getType() {
        return LocationType.CUSTOMER_LOCATION;
    }
}
