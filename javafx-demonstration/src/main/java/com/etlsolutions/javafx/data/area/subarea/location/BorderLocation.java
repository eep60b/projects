package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class BorderLocation extends GroundLocation {

    public BorderLocation() {
    }

    public BorderLocation(LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(locationValueWrapper, measurement);
    }
    
    @Override
    public LocationType getType() {
        return LocationType.BORDER_LOCATION;
    }
}
