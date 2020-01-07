package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public enum GwiseShapeType {

    POLYGON("Polygon"),
    
    RECTANGLE("Rectangle"), 
    
    SQURE ("Squre"), //This is probably not needed.
    
    CIRCLE ("Circle"), 
    
    TRIANGLE("Triangle"), 
    
    IRREGULAR("Irregular");     //This is probably not needed.
    
    
    private final String title;

    private GwiseShapeType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    
    
    @Override
    public String toString() {
        return title;
    }
}
