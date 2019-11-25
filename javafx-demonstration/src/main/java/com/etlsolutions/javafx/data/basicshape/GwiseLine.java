package com.etlsolutions.javafx.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseLine implements GwiseShape {
    
    private GwisePoint startPoint;
    private GwisePoint endPoint;

    public GwiseLine() {
    }

    public GwiseLine(GwisePoint startPoint, GwisePoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public GwisePoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(GwisePoint startPoint) {
        this.startPoint = startPoint;
    }

    public GwisePoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(GwisePoint endPoint) {
        this.endPoint = endPoint;
    }

    public double getLengthSquare() {
        return  (startPoint.getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX()) + (startPoint.getY() - endPoint.getY()) * (startPoint.getY() - endPoint.getY());
    }

    @Override
    public double getArea() {
        return 0;
    }
 
    @Override
    public double getPerimeter() {
        return Math.sqrt(getLengthSquare());
    }
}
