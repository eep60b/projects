package com.etlsolutions.javafx.data.log.gvent;

/**
 *
 * @author zc
 */
public enum GventType {

    FLOWERING("Flowering"), FRUITING("Fruiting"), CUSTOM("Custom");

    private final String displayString;

    private GventType(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
}
