package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseCircleBean implements GwiseShapeBean {

    private GwisePointBean center;
    private double radius;

    public GwiseCircleBean() {
    }

    public GwiseCircleBean(GwiseCircle circle) {
        this.center = new GwisePointBean(circle.getCenter());
        this.radius = circle.getRadius();
    }

    public GwisePointBean getCenter() {
        return center;
    }

    public void setCenter(GwisePointBean center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
