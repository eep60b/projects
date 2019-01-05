package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class GreenHouseGroundLocation extends GroundLocation {

    public GreenHouseGroundLocation() {
    }

    public GreenHouseGroundLocation(LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(locationValueWrapper, measurement);
    }

    @Override
    public LocationType getType() {
        return LocationType.GREEN_HOUSE_GROUND_LOCATION;
    }
}
