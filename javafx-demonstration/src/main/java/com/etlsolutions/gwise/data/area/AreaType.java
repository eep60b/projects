package com.etlsolutions.gwise.data.area;

import com.etlsolutions.javafx.data.area.GwiseShapeType;
import static com.etlsolutions.javafx.data.area.GwiseShapeType.*;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import static com.etlsolutions.javafx.data.area.subarea.SubAreaType.*;

/**
 *
 * @author zc
 */
public enum AreaType {

    GARDEN("Garden", new GwiseShapeType[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{PLANT_BED, RAISED_PLANT_BED, LAWN, BORDER, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, POND, SubAreaType.CUSTOM}), 
    
    INDOOR("Indoor Area", new GwiseShapeType[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{CONTAINTER_SET, SINGLE_CONTAINTER, ROOM, SubAreaType.CUSTOM}), 
    
    PATIO("Patio", new GwiseShapeType[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, new SubAreaType[]{RAISED_PLANT_BED, GREEN_HOUSE, CONTAINTER_SET, SINGLE_CONTAINTER, SubAreaType.CUSTOM}),

    /**
     *
     */
    BALCONY("Balcony", new GwiseShapeType[]{RECTANGLE, SQURE, IRREGULAR}, new SubAreaType[]{CONTAINTER_SET, SINGLE_CONTAINTER, SubAreaType.CUSTOM}), 
    
    ALLOTMENT("Allotment", new GwiseShapeType[]{RECTANGLE, SQURE}, new SubAreaType[]{PLANT_BED, RAISED_PLANT_BED, BORDER, GREEN_HOUSE, SubAreaType.CUSTOM}), 
    
    FARM("Farm", new GwiseShapeType[]{RECTANGLE, SQURE, IRREGULAR}, new SubAreaType[]{}), 
    
    CUSTOM("Custom Area", new GwiseShapeType[]{RECTANGLE, SQURE, CIRCLE, TRIANGLE, IRREGULAR}, SubAreaType.values());

    private final String title;
    private final GwiseShapeType[] shapes;    
    private final SubAreaType[] subAreaTypes;

    private AreaType(String title, GwiseShapeType[] shapes, SubAreaType[] subAreaTypes) {
        this.title = title;
        this.shapes = shapes;        
        this.subAreaTypes = subAreaTypes;
    }

    public String getTitle() {
        return title;
    }

    public GwiseShapeType[] getShapes() {
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
