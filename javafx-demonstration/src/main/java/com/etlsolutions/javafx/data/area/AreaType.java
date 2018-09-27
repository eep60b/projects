package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public enum AreaType {

    GARDEN("Garden"), INDOOR("Indoor Area"), PATIO("Patio"), BALCONY("Balcony"), ALLOTMENT("Allotment"), FARM("Farm"), CUSTOM("Custom Area");

    private final String title;

    private AreaType(String title) {
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
