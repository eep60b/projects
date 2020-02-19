package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseArcLine implements GwiseLineShape {

    private final GwisePoint center;
    private final double radius;
    private final double width;
    private final double length;

    public GwiseArcLine(GwisePoint center, double radius, double width, double length) {
        this.center = center;
        this.radius = radius;
        this.width = width;
        this.length = length;
    }

    public GwiseArcLine(GwiseArcLineBean bean) {
        center = new GwisePoint(bean.getCenter());
        radius = bean.getRadius();
        width = bean.getWidth();
        length = bean.getLength();
    }
    
    public GwisePoint getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public GwiseLineShapeType getType() {
        return GwiseLineShapeType.ARC;
    }
}
