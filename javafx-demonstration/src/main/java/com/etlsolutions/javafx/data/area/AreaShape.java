package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public abstract class AreaShape {
    
    private double area;
    
    public abstract AreaShapeType getType();

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
