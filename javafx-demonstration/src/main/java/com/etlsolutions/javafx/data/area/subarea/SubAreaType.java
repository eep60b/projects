package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public enum SubAreaType {
    
    BORDER ("Border"),
    SINGLE_CONTAINTER ("Container"),
    CONTAINTER_SET ("Container Set"),
    CUSTOM ("Custom area"),
    GREEN_HOUSE ("Green house"),
    LAWN ("Lawn"),
    PLANT_BED ("Plant bed"),
    POND ("Pond"),
    RAISED_PLANT_BED ("Raised Plant Bed"),
    ROOM ("Room");
    
    
    private String title;
    
    private SubAreaType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
    
    
}
