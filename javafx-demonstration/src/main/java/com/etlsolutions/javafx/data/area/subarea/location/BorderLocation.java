package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class BorderLocation extends GroundLocation {

    public BorderLocation() {
    }

    public BorderLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper, measurement);
    }
    
    @Override
    public LocationType getType() {
        return LocationType.BORDER_LOCATION;
    }
}
