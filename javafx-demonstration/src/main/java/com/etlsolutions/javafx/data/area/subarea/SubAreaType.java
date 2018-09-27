package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public enum SubAreaType {
    
    BORDER ("Border"),
    SINGLE_CONTAINTER ("Single Container"),
    CONTAINTER_SET ("Container Set"),
    CUSTOM ("Custom area"),
    GREEN_HOUSE ("Greenhouse"),
    LAWN ("Lawn"),
    PLANT_BED ("Plant Bed"),
    POND ("Pond"),
    RAISED_PLANT_BED ("Raised Plant Bed"),
    ROOM ("Room");
    
    
    private final String title;
    
    private SubAreaType(String title) {
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
