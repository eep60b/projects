package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class PondLocation extends GroundLocation {

    public PondLocation() {
    }

    public PondLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper, measurement);
    }
    
    @Override
    public LocationType getType() {
        return LocationType.POND_LOCATION;
    }
}
