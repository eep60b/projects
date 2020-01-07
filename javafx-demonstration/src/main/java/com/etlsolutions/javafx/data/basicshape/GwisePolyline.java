package com.etlsolutions.javafx.data.basicshape;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polyline;

/**
 *
 * @author ZhipengChang
 */
public class GwisePolyline implements GwiseShape {

    private ObservableListWrapperA<GwisePoint> points = new ObservableListWrapperA<>();
    private ObservableListWrapperA<GwiseLine> lines = new ObservableListWrapperA<>();

    public GwisePolyline() {
    }

    public GwisePolyline(Polyline polyLine) {

        ObservableList<Double> pointValues = polyLine.getPoints();
        for (int i = 0; i < pointValues.size() - 2; i++) {
            points.add(new GwisePoint(pointValues.get(i), pointValues.get(i + 1)));
        }
        addLines(points);
    }

    public GwisePolyline(ObservableListWrapperA<GwisePoint> points) {

        this.points = new ObservableListWrapperA<>(points);
        addLines(this.points);
    }

    private void addLines(ObservableListWrapperA<GwisePoint> ps) {
        for (int i = 0; i < ps.size() - 1; i++) {
            lines.add(new GwiseLine(ps.get(i), ps.get(i + 1)));
        }
    }

    public ObservableListWrapperA<GwisePoint> getPoints() {
        return points;
    }

    public void setPoints(ObservableListWrapperA<GwisePoint> points) {
        this.points = points;
    }

    public ObservableListWrapperA<GwiseLine> getLines() {
        return lines;
    }

    public void setLines(ObservableListWrapperA<GwiseLine> lines) {
        this.lines = lines;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        double total = 0;

        for (GwiseLine line : lines) {
            total = total + line.perimeter();
        }

        return total;
    }

    public double[] pointArray() {
        double[] array = new double[points.size() * 2];

        for (int i = 0; i < points.size(); i++) {

            GwisePoint p = points.get(i);
            array[2 * i] = p.getX();
            array[2 * i + 1] = p.getX();
        }
        return array;
    }
}
