package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.*;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;

/**
 *
 * @author zc
 */
public enum SubAreaType {
    
    BORDER ("Border", new MeasurementType[]{MeasurementType.BORDER}, LocationType.BORDER_LOCATION),
    SINGLE_CONTAINTER ("Single Container", new MeasurementType[]{}, LocationType.CONTAINER),
    CONTAINTER_SET ("Container Set", new MeasurementType[]{NUMBER}, LocationType.CONTAINER),
    CUSTOM ("Custom area", MeasurementType.values(), LocationType.CONTAINER, LocationType.CUSTOMER_LOCATION),
    GREEN_HOUSE ("Greenhouse", new MeasurementType[]{RECTANGLE, SQUARE, IRREGULAR}, LocationType.CONTAINER, LocationType.GREEN_HOUSE_GROUND_LOCATION),
    LAWN ("Lawn", new MeasurementType[]{RECTANGLE, SQUARE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.LAWN_LOCATION),
    PLANT_BED ("Plant Bed", new MeasurementType[]{RECTANGLE, SQUARE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.PLANT_BED_LOCATION),
    POND ("Pond", new MeasurementType[]{RECTANGLE, SQUARE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.POND_LOCATION),
    RAISED_PLANT_BED ("Raised Plant Bed", new MeasurementType[]{RECTANGLE, SQUARE, CIRCLE, TRIANGLE, IRREGULAR}, LocationType.PLANT_BED_LOCATION),
    ROOM ("Room", new MeasurementType[]{RECTANGLE, SQUARE, IRREGULAR}, LocationType.CONTAINER);
    
    
    private final String title;
    private final MeasurementType[] shapes;
    private final LocationType[] locationTypes;
    
    private SubAreaType(String title, MeasurementType[] shapes, LocationType ... locationTypes) {
        this.title = title;
        this.shapes = shapes;
        this.locationTypes = locationTypes;
    }

    public String getTitle() {
        return title;
    }

    public MeasurementType[] getShapes() {
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
