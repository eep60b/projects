package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class GreenHouseGroundLocation extends GroundLocation {

    public GreenHouseGroundLocation() {
    }

    public GreenHouseGroundLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper, measurement);
    }

    @Override
    public LocationType getType() {
        return LocationType.GREEN_HOUSE_GROUND_LOCATION;
    }
}
