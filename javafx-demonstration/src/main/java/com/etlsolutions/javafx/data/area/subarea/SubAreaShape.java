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
    
    /**
     * Round border subarea
     */
    ROUND("Round"),
    
    GOTHIC("Gothic"),
    
    HOOP("Hoop"), 
    
    DOOM("Doom"), 
    
    LEAN_TO_WALL("Lean-to-wall"), 
    
    /**
     * Straight line border.
     */
    STRAIGHT_LINE("Straight line"),   
    
    POND("Pond"),
    
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
