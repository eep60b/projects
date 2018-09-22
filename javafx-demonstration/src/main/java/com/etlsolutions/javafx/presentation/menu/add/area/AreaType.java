package com.etlsolutions.javafx.presentation.menu.add.area;

/**
 *
 * @author Zhipeng
 */
public enum AreaType {

    GARDEN("Garden"),
    PATIO("Patio"),
    INDOOR("Indoor Area"),
    BALCONY("Balcony"),
    ALLOTMENT("Allotment"),
    FARM("Farm"), 
    CUSTOM("Custom Area");

    private final String fullName;

    private AreaType(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }

}
