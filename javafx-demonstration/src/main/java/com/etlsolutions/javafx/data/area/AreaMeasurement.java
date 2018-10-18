package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public abstract class AreaMeasurement {
    
    protected double areaValue;
    
    public abstract AreaShape getType();

    public double getAreaValue() {
        return areaValue;
    }    
}
