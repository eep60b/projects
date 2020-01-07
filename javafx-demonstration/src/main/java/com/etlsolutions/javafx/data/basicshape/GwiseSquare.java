package com.etlsolutions.javafx.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseSquare extends GwiseRectangle {

    public GwiseSquare() {
    }

    public GwiseSquare(GwisePoint point, double side) {
        this(point.getX(), point.getY(), side);
    }

    public GwiseSquare(double x, double y, double side) {
        super(x, y, side, side);
    }
    
    public double getSide() {
        return getHeight();
    }

    @Override
    public double area() {
        return getSide() * getSide(); 
    }

    @Override
    public double perimeter() {
        return 4 * getSide();
    }
}
