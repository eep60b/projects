package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class PlantBedLocation extends GroundLocation {

    public PlantBedLocation() {
    }

    public PlantBedLocation(DataUnitValueWrapper dataUnitCommonDataValueWrapper, LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(dataUnitCommonDataValueWrapper, locationValueWrapper, measurement);
    }

    @Override
    public LocationType getType() {
        return LocationType.PLANT_BED_LOCATION;
    }
}
