package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public enum LocationType {

    CONTAINER("Container", LocationMeasurementType.CONTAINER), 
    BORDER_LOCATION("Border location", LocationMeasurementType.GROUND_LOCATION), 
    CUSTOMER_LOCATION ("Customer location", LocationMeasurementType.GROUND_LOCATION),
    LAWN_LOCATION("Law location", LocationMeasurementType.GROUND_LOCATION),
    GREEN_HOUSE_GROUND_LOCATION("Green house groud", LocationMeasurementType.GROUND_LOCATION), 
    PLANT_BED_LOCATION("Plant bed location", LocationMeasurementType.GROUND_LOCATION), 
    POND_LOCATION("Pond location", LocationMeasurementType.GROUND_LOCATION);

    private final String displayString;
    private final LocationMeasurementType measurementType;

    private LocationType(String displayString, LocationMeasurementType measurementType) {
        this.displayString = displayString;
        this.measurementType = measurementType;
    }

    public String getDisplayString() {
        return displayString;
    }

    public LocationMeasurementType getMeasurementType() {
        return measurementType;
    }
    
    @Override
    public String toString() {
        return displayString;
    }
}
