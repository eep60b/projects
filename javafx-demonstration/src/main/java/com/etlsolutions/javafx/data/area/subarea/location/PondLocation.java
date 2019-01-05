package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class PondLocation extends GroundLocation {

    public PondLocation() {
    }

    public PondLocation(LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(locationValueWrapper, measurement);
    }
    
    @Override
    public LocationType getType() {
        return LocationType.POND_LOCATION;
    }
}
