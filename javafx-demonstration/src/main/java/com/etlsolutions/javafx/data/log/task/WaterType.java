package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public enum WaterType {
  
    RAIN_WATER("Rain water"), TAP_WATER("Tap water");
    
    
    private final String disaplyString;
    
    private WaterType(String disaplyString) {
        this.disaplyString = disaplyString;
    }

    @Override
    public String toString() {
        return disaplyString;
    }
}
