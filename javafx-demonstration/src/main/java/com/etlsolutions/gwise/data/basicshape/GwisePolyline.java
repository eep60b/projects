package com.etlsolutions.gwise.data.basicshape;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polyline;

/**
 *
 * @author ZhipengChang
 */
public class GwisePolyline implements GwiseLineShape {

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

    GwisePolyline(GwisePolylineBean bean) {
        for(GwisePointBean point : bean.getPoints()) {
            points.add(new GwisePoint(point));
        }
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

    public double[] pointArray() {
        double[] array = new double[points.size() * 2];

        for (int i = 0; i < points.size(); i++) {

            GwisePoint p = points.get(i);
            array[2 * i] = p.getX();
            array[2 * i + 1] = p.getX();
        }
        return array;
    }

    @Override
    public GwiseLineShapeType getType() {
        return GwiseLineShapeType.POLYLINE;
    }
}
