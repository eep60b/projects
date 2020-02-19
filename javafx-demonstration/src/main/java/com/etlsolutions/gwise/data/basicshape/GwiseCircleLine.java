package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseCircleLine implements GwiseLineShape {
       
    private final GwisePoint center;
    private final double radius;
    private final double width;

    /**
     *
     * @param center
     * @param radius
     * @param width
     */
    public GwiseCircleLine(GwisePoint center, double radius, double width) {
        this.center = center;
        this.radius = radius;
        this.width = width;
    }

    public GwiseCircleLine(GwiseCircleLineBean bean) {
        center = new GwisePoint(bean.getCenter());
        radius = bean.getRadius();
        width = bean.getWidth();
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

    @Override
    public GwiseLineShapeType getType() {
        
        return GwiseLineShapeType.CIRCLE;
    }
}
