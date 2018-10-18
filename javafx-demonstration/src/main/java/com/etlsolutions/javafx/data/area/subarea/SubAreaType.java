package com.etlsolutions.javafx.data.area.subarea;

import static com.etlsolutions.javafx.data.area.subarea.SubAreaShape.*;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public enum SubAreaType {
    
    BORDER ("Border", new SubAreaShape[]{STREIGHT_LINE, CIRCLE, IRREGULAR}, LocationType.BORDER_LOCATION),
    SINGLE_CONTAINTER ("Single Container", new SubAreaShape[]{ROUND, RECTANGLE, SQURE, IRREGULAR}, LocationType.CONTAINER),
    CONTAINTER_SET ("Container Set", new SubAreaShape[]{ROUND, RECTANGLE, SQURE, IRREGULAR}, LocationType.CONTAINER),
    CUSTOM ("Custom area", SubAreaShape.values(), LocationType.CONTAINER, LocationType.CUSTOMER_LOCATION),
    GREEN_HOUSE ("Greenhouse", new SubAreaShape[]{RECTANGLE, SQURE, LEAN_TO_WALL, DOOM, GOTHIC, HOOP, IRREGULAR}, LocationType.CONTAINER, LocationType.GREEN_HOUSE_GROUND_LOCATION),
    LAWN ("Lawn", new SubAreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.LAWN_LOCATION),
    PLANT_BED ("Plant Bed", new SubAreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.PLANT_BED_LOCATION),
    POND ("Pond", new SubAreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.POND_LOCATION),
    RAISED_PLANT_BED ("Raised Plant Bed", new SubAreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.PLANT_BED_LOCATION),
    ROOM ("Room", new SubAreaShape[]{RECTANGLE, SQURE, DOOM, IRREGULAR}, LocationType.CONTAINER);
    
    
    private final String title;
    private final SubAreaShape[] shapes;
    private LocationType[] locationTypes;
    
    private SubAreaType(String title, SubAreaShape[] shapes, LocationType ... locationTypes) {
        this.title = title;
        this.shapes = shapes;
        this.locationTypes = locationTypes;
    }

    public String getTitle() {
        return title;
    }

    public SubAreaShape[] getShapes() {
        return shapes;
    }

    public LocationType[] getLocationTypes() {
        return locationTypes;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
