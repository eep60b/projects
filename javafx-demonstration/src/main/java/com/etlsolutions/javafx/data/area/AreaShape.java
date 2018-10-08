package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public abstract class AreaShape {
    
    protected double area;
    
    public abstract AreaShapeType getType();

    public double getArea() {
        return area;
    }    
}
