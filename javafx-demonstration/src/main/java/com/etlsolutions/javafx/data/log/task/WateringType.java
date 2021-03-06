package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public enum WateringType {
    
    USE_WATER_CAN ("Use water can"), USE_HOSE("Use hose");
    
    private final String displayString;
    
    private WateringType(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
    
    
}
