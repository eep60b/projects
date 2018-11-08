package com.etlsolutions.javafx.data.other;

/**
 *
 * @author zc
 */
public enum FertiliserType {
    
    SOLID ("Solid"), LIQUID ("Liquid");
    
    private final String displayString;
    
    private FertiliserType(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
    
    
}
