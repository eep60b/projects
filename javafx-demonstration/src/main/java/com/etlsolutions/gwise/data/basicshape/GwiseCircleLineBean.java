package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseCircleLineBean implements GwiseLineShapeBean {

    private GwisePointBean center;
    private double radius;
    private double width;

    public GwiseCircleLineBean(GwiseCircleLine line) {
        center = new GwisePointBean(line.getCenter());
        radius = line.getRadius();
        width = line.getWidth();
    }

    public GwiseCircleLineBean() {
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
