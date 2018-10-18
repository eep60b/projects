package com.etlsolutions.javafx.data.area.subarea.location;

/**
 *
 * @author zc
 */
public enum LocationType {

    CONTAINER("Container"), 
    BORDER_LOCATION("Border location"), 
    CUSTOMER_LOCATION ("Customer location"),
    LAWN_LOCATION("Law location"),
    GREEN_HOUSE_GROUND_LOCATION("Green house groud"), 
    PLANT_BED_LOCATION("Plant bed location"), 
    POND_LOCATION("Pond location");

    private final String displayString;

    private LocationType(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
}
