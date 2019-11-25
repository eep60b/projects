package com.etlsolutions.javafx.data.basicshape;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Polygon;

/**
 * The GwisePolygon class represent a simple polygon (lines are not intersect
 * each other) shape for area or subarea. The starting point will be the leftest
 * point (smallest x value). If serval points has the same smallest x value, the
 * smallest, the point with smallest y value. will be used as the first point.
 * This guarantees the first point is not a convex vert.
 *
 * @author ZhipengChang
 */
public class GwisePolygon implements GwiseShape {

    private ObservableListWrapperA<GwisePoint> points;
    private ObservableListWrapperA<GwiseLine> lines;
    private List<GwiseTriangle> triangles;

    public GwisePolygon() {
    }

    public GwisePolygon(Polygon p) {

        List<Double> v = p.getPoints();

        List<GwisePoint> originalPointList = new ArrayList<>();

        for (int i = 0; i <= v.size() - 2; i = i + 2) {
            originalPointList.add(new GwisePoint(v.get(i), v.get(i + 1)));
        }

        load(originalPointList);
    }

    public GwisePolygon(List<GwisePoint> originalPointList) {

        load(originalPointList);
    }

    protected final void load(List<GwisePoint> originalPointList) {
        points = createPoints(originalPointList);
        lines = createLines(points);
        triangles = getTriangles(new ArrayList<>(points));
    }

    private ObservableListWrapperA<GwisePoint> createPoints(List<GwisePoint> originalPointList) {

        GwisePoint f = originalPointList.get(0);
        int index = 0;

        for (int i = 1; i < originalPointList.size(); i++) {
            GwisePoint point = originalPointList.get(i);
            if (point.getX() < f.getX() || (point.getX() == f.getX() && point.getY() < f.getY())) {
                f = point;
                index = i;
            }
        }

        List<GwisePoint> subList1 = new ArrayList<>(originalPointList);
        for (int i = index - 1; i > 0; i--) {
            subList1.remove(i);
        }
        ObservableListWrapperA<GwisePoint> l = new ObservableListWrapperA<>(subList1);
        List<GwisePoint> subList2 = new ArrayList<>(originalPointList);
        for (int i = index; i < originalPointList.size(); i++) {
            subList2.remove(i);
        }

        l.addAll(subList2);
        return l;
    }

    private ObservableListWrapperA<GwiseLine> createLines(ObservableListWrapperA<GwisePoint> points) {
        ObservableListWrapperA<GwiseLine> list = new ObservableListWrapperA<>();
        List<GwisePoint> ps = new ArrayList<>(points);

        //Add the first point to the back to make a circuit.
        ps.add(points.get(0));

        for (int i = 0; i < ps.size() - 2; i++) {
            list.add(new GwiseLine(ps.get(i), ps.get(i + 1)));
        }
        return list;
    }

    private List<GwiseTriangle> getTriangles(List<GwisePoint> points) {

        List<GwiseTriangle> list = new ArrayList<>();

        while (points.size() >= 3) {
            GwiseTriangle triangle = new GwiseTriangle(points.get(0), points.get(1), points.get(points.size() - 1));
            list.add(triangle);
            points.remove(0);
            points = new GwisePolygon(points).getPoints();
        }

        return list;
    }

    public ObservableListWrapperA<GwisePoint> getPoints() {
        return new ObservableListWrapperA<>(points);
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

    public List<GwiseTriangle> getTriangles() {
        return triangles;
    }

    public void setTriangles(List<GwiseTriangle> triangles) {
        this.triangles = triangles;
    }

    public boolean isOverlapping(GwiseTriangle triangle) {

        for (GwiseTriangle t : triangles) {
            if (t.isOverlapping(triangle)) {
                return true;
            }
        }

        return false;
    }

    public boolean isOverlapping(GwisePolygon polygon) {

        for (GwiseTriangle triangle : triangles) {
            if (polygon.isOverlapping(triangle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverLapping(GwiseCircle circle) {

        for (GwiseTriangle triangle : triangles) {
            if (triangle.isOverlapping(circle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getArea() {
        double area = 0;
        for (GwiseTriangle triangle : triangles) {
            area = area + triangle.getArea();
        }

        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;

        for (GwiseLine line : lines) {
            perimeter = perimeter + line.getPerimeter();
        }

        return perimeter;
    }
}
