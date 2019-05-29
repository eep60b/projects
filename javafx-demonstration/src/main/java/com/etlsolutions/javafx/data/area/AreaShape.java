package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public enum AreaShape {

    POLYGON("Polygon"),
    
    RECTANGLE("Rectangle"), 
    
    SQURE ("Squre"), 
    
    CIRCLE ("Circle"), 
    
    TRIANGLE("Triangle"), 
    
    IRREGULAR("Irregular");
    
    
    private final String title;

    private AreaShape(String title) {
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
