package com.etlsolutions.javafx.data.area;

import static com.etlsolutions.javafx.data.area.AreaShape.*;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public enum AreaType {

    GARDEN("Garden", new AreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{PLANT_BED, RAISED_PLANT_BED, LAWN, BORDER, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, POND, SubAreaType.CUSTOM}), 
    
    INDOOR("Indoor Area", new AreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{CONTAINTER_SET, SINGLE_CONTAINTER, ROOM, SubAreaType.CUSTOM}), 
    
    PATIO("Patio", new AreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{RAISED_PLANT_BED, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, SubAreaType.CUSTOM}),

    /**
     *
     */
    BALCONY("Balcony", new AreaShape[]{RECTANGLE, SQURE, IRREGULAR}, new SubAreaType[]{CONTAINTER_SET, SINGLE_CONTAINTER, SubAreaType.CUSTOM}), 
    
    ALLOTMENT("Allotment", new AreaShape[]{RECTANGLE, SQURE}, new SubAreaType[]{PLANT_BED, RAISED_PLANT_BED, BORDER, GREEN_HOUSE, SubAreaType.CUSTOM}), 
    
    FARM("Farm", new AreaShape[]{RECTANGLE, SQURE, IRREGULAR}, new SubAreaType[]{}), 
    
    CUSTOM("Custom Area", new AreaShape[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, SubAreaType.values());

    private final String title;
    private final AreaShape[] shapes;    
    private final SubAreaType[] subAreaTypes;

    private AreaType(String title, AreaShape[] shapes, SubAreaType[] subAreaTypes) {
        this.title = title;
        this.shapes = shapes;        
        this.subAreaTypes = subAreaTypes;
    }

    public String getTitle() {
        return title;
    }

    public AreaShape[] getShapes() {
        return shapes;
    }

    public SubAreaType[] getSubAreaTypes() {
        return subAreaTypes;
    }

    @Override
    public String toString() {
        return title;
    }
}
