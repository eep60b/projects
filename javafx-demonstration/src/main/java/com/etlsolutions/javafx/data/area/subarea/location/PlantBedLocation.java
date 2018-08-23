package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zc
 */
public class PlantBedLocation extends Location {

    @JsonIgnore
    public static final String DIRECTION_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation.REFERENCE_POINT_PROPERTY";
    @JsonIgnore
    public static final String OCCUPIED_AREA_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.PlantBedLocation.OCCUPIED_AREA_PROPERTY";
    
    private String direction;
    private double occupiedArea;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {

        String oldValue = this.direction;
        this.direction = direction;
        fireChange(DIRECTION_PROPERTY, oldValue, this.direction);
    }

    public double getOccupiedArea() {
        return occupiedArea;
    }

    public void setOccupiedArea(double occupiedArea) {
        double oldValue = this.occupiedArea;
        this.occupiedArea = occupiedArea;
        fireChange(OCCUPIED_AREA_PROPERTY, oldValue, this.occupiedArea);
    }

    public List<String> getDefaultReferentialPositions() {
        return Arrays.asList("central", "northeast corner", "northwest corner", "southeast corner", "southwest corner");
    }
}
