package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.log.LogType;

/**
 *
 * @author zc
 */
public enum GventType implements LogType {

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
