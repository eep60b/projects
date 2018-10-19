package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public enum SubAreaShape {

    RECTANGLE("Rectangle"), 
    
    SQURE ("Squre"), 
    
    CIRCLE ("Circle"), 
    
    TRIANGLE("Triangle"), 
    
    ROUND("Round"),
    
    GOTHIC("Gothic"),
    
    HOOP("Hoop"), 
    
    DOOM("Doom"), 
    
    LEAN_TO_WALL("Lean-to-wall"), 
    
    STREIGHT_LINE("Streight line"),    
    
    IRREGULAR("Irregular");

    private final String title;

    private SubAreaShape(String title) {
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
