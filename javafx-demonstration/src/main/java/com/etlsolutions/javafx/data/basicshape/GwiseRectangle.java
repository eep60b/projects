package com.etlsolutions.javafx.data.basicshape;

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
        ObservableListWrapperA<GwisePoint> list = new ObservableListWrapperA<>();
        list.add(new GwisePoint(x, y));
        list.add(new GwisePoint(x + width, y));
        list.add(new GwisePoint(x + width, y + height));
        list.add(new GwisePoint(x, y + height));
        load(list);
    }

    public double getX() {
        return getPoints().get(0).getX();
    }

    public double getY() {
        return getPoints().get(0).getY();
    }

    public double getHeight() {
        return getLines().get(1).getPerimeter();
    }

    public double getWidth() {
        return getLines().get(0).getPerimeter();
    }

    @Override
    public double getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }
}
