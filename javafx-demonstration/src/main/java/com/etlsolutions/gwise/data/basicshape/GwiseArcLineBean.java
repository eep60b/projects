package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseArcLineBean implements GwiseLineShapeBean {

    private GwisePointBean center;
    private double radius;
    private double width;
    private double length;

    public GwiseArcLineBean() {
    }

    public GwiseArcLineBean(GwiseArcLine line) {

        center = new GwisePointBean(line.getCenter());
        radius = line.getRadius();
        width = line.getWidth();
        length = line.getLength();
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
