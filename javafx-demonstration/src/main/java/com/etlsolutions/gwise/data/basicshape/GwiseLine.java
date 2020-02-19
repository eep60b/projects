package com.etlsolutions.gwise.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLine implements  GwiseLineShape {
    
    private final GwisePoint startPoint;
    private final GwisePoint endPoint;


    public GwiseLine(GwisePoint startPoint, GwisePoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public GwiseLine(GwiseLineBean bean) {
        startPoint = new GwisePoint(bean.getStartPoint());
        endPoint = new GwisePoint(bean.getEndPoint());
    }
    
    public GwisePoint getStartPoint() {
        return startPoint;
    }

    public GwisePoint getEndPoint() {
        return endPoint;
    }

    public double getLengthSquare() {
        return  (startPoint.getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX()) + (startPoint.getY() - endPoint.getY()) * (startPoint.getY() - endPoint.getY());
    }

    public double getLength() {
        return Math.sqrt(getLengthSquare());
    }

    @Override
    public GwiseLineShapeType getType() {
        return GwiseLineShapeType.LINE;
    }
}
