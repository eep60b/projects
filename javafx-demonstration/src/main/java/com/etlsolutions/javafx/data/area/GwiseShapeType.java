package com.etlsolutions.javafx.data.area;

/**
 * The GwiseShapeType enum defines the type of shapes for areas and subareas.
 * @author zc
 */
public enum GwiseShapeType {

    POLYGON("Polygon", ""),
    
    RECTANGLE("Rectangle", ""), 
    
    SQURE ("Squre", ""), //This is probably not needed.
    
    CIRCLE ("Circle", ""), 
    
    TRIANGLE("Triangle", ""), 
    
    IRREGULAR("Irregular", "");     //This is probably not needed.
    
    private final String title;
    private final String logoFilePath;

    private GwiseShapeType(String title, String logoFilePath) {
        this.title = title;
        this.logoFilePath = logoFilePath;
    }

    public String getTitle() {
        return title;
    }

    public String getLogoFilePath() {
        return logoFilePath;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
