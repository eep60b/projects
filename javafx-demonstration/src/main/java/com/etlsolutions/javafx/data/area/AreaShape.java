package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public abstract class AreaShape {
    
    protected double areaValue;
    
    public abstract AreaShapeType getType();

    public double getAreaValue() {
        return areaValue;
    }    
}
