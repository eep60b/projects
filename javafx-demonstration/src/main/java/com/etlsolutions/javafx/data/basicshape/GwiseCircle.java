package com.etlsolutions.javafx.data.basicshape;

import static com.etlsolutions.javafx.system.SettingConstants.PI;

/**
 *
 * @author ZhipengChang
 */
public class GwiseCircle implements GwiseShape {
    
    private GwisePoint center;
    private double radius;

    public GwiseCircle() {
    }

    public GwiseCircle(GwisePoint center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public GwisePoint getCenter() {
        return center;
    }

    public void setCenter(GwisePoint center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }    

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
