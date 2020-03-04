package com.etlsolutions.gwise.data.subarea;

/**
 * The GwiseSubAreaType enum define the type of subareas.
 * @author zc
 */
public enum GwiseSubAreaType {
    
    BORDER ("Border"),
    GREEN_HOUSE ("Greenhouse"),
    LAWN ("Lawn"),
    PLANT_BED ("Plant Bed"),
    POND ("Pond"),
    RAISED_PLANT_BED ("Raised Plant Bed"),
    ROOM ("Room");
        
    private final String title;
    
    private GwiseSubAreaType(String title) {
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
