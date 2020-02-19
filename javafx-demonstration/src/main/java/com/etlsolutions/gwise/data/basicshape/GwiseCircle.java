package com.etlsolutions.gwise.data.basicshape;

import static com.etlsolutions.javafx.system.SettingConstants.PI;
import java.math.BigDecimal;
import javafx.scene.shape.Circle;

/**
 *
 * @author ZhipengChang
 */
public class GwiseCircle implements GwiseShape {
    
    private GwisePoint center;
    private double radius;

    public GwiseCircle() {
    }

    public GwiseCircle(GwiseCircleBean bean) {
        this.center = new GwisePoint(bean.getCenter());
        this.radius = bean.getRadius();
    }

    public GwiseCircle(Circle circle) {
        center = new GwisePoint(circle.getCenterX(), circle.getCenterY());
        radius = circle.getRadius();
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
    public double area() {
        return new BigDecimal(PI * radius * radius).setScale(2).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal(2 * PI * radius).setScale(2).doubleValue();
    }

    @Override
    public GwiseShapeType getType() {
        return GwiseShapeType.CIRCLE;
    }
}
