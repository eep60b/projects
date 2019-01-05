package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public class PlantBedLocation extends GroundLocation {

    public PlantBedLocation() {
    }

    public PlantBedLocation(LocationValueWrapper locationValueWrapper, GroundLocationMeasurement measurement) {
        super(locationValueWrapper, measurement);
    }

    @Override
    public LocationType getType() {
        return LocationType.PLANT_BED_LOCATION;
    }
}
