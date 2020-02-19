package com.etlsolutions.gwise.data.basicshape;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ZhipengChang
 */
public class GwiseRectangle extends GwisePolygon {

    public GwiseRectangle() {
    }

    public GwiseRectangle(Rectangle r) {

        this(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    public GwiseRectangle(GwisePoint point1, GwisePoint point2) {

        this(point1.getX(), point1.getY(), point2.getX() - point1.getX(), point2.getY() - point1.getY());
    }

    public GwiseRectangle(double x, double y, double width, double height) {

        GwisePoint A = new GwisePoint(x, y);
        GwisePoint B = new GwisePoint(x + width, y);
        GwisePoint C = new GwisePoint(x + width, y + height);
        GwisePoint D = new GwisePoint(x, y + height);
        points = new ObservableListWrapperA<>(A, B, C, D);
        lines = new ObservableListWrapperA<>(new GwiseLine(A, B), new GwiseLine(B, C), new GwiseLine(C, D), new GwiseLine(D, A));
        triangles = new ObservableListWrapperA<>(new GwiseTriangle(A, D, C), new GwiseTriangle(A, C, B));
    }

    public GwiseRectangle(GwiseRectangleBean bean) {
        super(bean);
    }

    public double getX() {
        return getPoints().get(0).getX();
    }

    public double getY() {
        return getPoints().get(0).getY();
    }

    public double getHeight() {
        return getLines().get(1).getLength();
    }

    public double getWidth() {
        return getLines().get(0).getLength();
    }

    @Override
    public double perimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    @Override
    public double area() {
        return getHeight() * getWidth();
    }
 
    @Override
    public GwiseShapeType getType() {
        return GwiseShapeType.RECTANGLE;
    }   
}
