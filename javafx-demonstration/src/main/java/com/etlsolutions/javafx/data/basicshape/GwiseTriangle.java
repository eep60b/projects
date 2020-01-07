package com.etlsolutions.javafx.data.basicshape;

import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author ZhipengChang
 */
public class GwiseTriangle extends GwisePolygon {

    private GwisePoint pointA;
    private GwisePoint pointB;
    private GwisePoint pointC;

    private GwiseLine sideA;
    private GwiseLine sideB;
    private GwiseLine sideC;

    public GwiseTriangle() {
    }

    public GwiseTriangle(GwisePoint p1, GwisePoint p2, GwisePoint p3) {
        
        GwisePoint p = p1.getX() < p2.getX() || (p1.getX() == p2.getX() && p1.getY() < p2.getY()) ? p1 : p2;
        
        pointA = p.getX() < p3.getX() || (p.getX() == p3.getX() && p.getY() < p3.getY()) ? p : p3;
        pointB = pointA == p1 ? p2 : pointA == p2 ? p3 : p1;
        pointC = pointA == p1 ? p3 : pointA == p2 ? p1 : p2;

        sideA = new GwiseLine(pointB, pointC);
        sideB = new GwiseLine(pointC, pointA);
        sideC = new GwiseLine(pointA, pointB);
        
        points = new ObservableListWrapperA<>(pointA, pointB, pointC);
        lines = new ObservableListWrapperA<>(sideC, sideA, sideB);
        triangles = new ObservableListWrapperA<>(this);
    }

    public GwisePoint getPointA() {
        return pointA;
    }

    public void setPointA(GwisePoint pointA) {
        this.pointA = pointA;
    }

    public GwisePoint getPointB() {
        return pointB;
    }

    public void setPointB(GwisePoint pointB) {
        this.pointB = pointB;
    }

    public GwisePoint getPointC() {
        return pointC;
    }

    public void setPointC(GwisePoint pointC) {
        this.pointC = pointC;
    }

    public GwiseLine getSideA() {
        return sideA;
    }

    public void setSideA(GwiseLine sideA) {
        this.sideA = sideA;
    }

    public GwiseLine getSideB() {
        return sideB;
    }

    public void setSideB(GwiseLine sideB) {
        this.sideB = sideB;
    }

    public GwiseLine getSideC() {
        return sideC;
    }

    public void setSideC(GwiseLine sideC) {
        this.sideC = sideC;
    }

 
    public boolean isOnLeftOf(GwisePoint point) {
        return pointA.isOnLeftOf(point) && pointB.isOnLeftOf(point) && pointC.isOnLeftOf(point);
    }

    public boolean isOnRightOf(GwisePoint point) {
        return point.isOnLeftOf(pointA) && point.isOnLeftOf(pointB) && point.isOnLeftOf(pointC);
    }

    public boolean isOnTopOf(GwisePoint point) {
        return pointA.isOnTopOf(point) && pointB.isOnTopOf(point) && pointC.isOnTopOf(point);
    }

    public boolean isOnBottomOf(GwisePoint point) {
        return point.isOnTopOf(pointA) && point.isOnTopOf(pointB) && point.isOnTopOf(pointC);
    }

    /**
     * Check if the specified point is inside this triangle. In general, the
     * simplest (and quite optimal) algorithm is checking on which side of the
     * half-plane created by the edges the point is.
     *
     * @param point - The specified point
     * @return true if it is inside otherwise return false.
     */
    public boolean contains(GwisePoint point) {

        double d1 = getSign(point, pointA, pointB);
        double d2 = getSign(point, pointB, pointC);
        double d3 = getSign(point, pointC, pointA);

        boolean hasNegtive = (d1 < 0) || (d2 < 0) || (d3 < 0);
        boolean hasPositive = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(hasNegtive && hasPositive);
    }

    private double getSign(GwisePoint p1, GwisePoint p2, GwisePoint p3) {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    /**
     * Check if the specified point is inside this triangle. This works the same
     * as contains() but using barycentric coordinates.
     *
     * @param point - The specified point
     * @return true if it is inside otherwise return false.
     */
    public boolean contains2(GwisePoint point) {

        double s = pointA.getY() * pointC.getX() - pointA.getX() * pointC.getY() + (pointC.getY() - pointA.getY()) * point.getX() + (pointA.getX() - pointC.getX()) * point.getY();
        double t = pointA.getX() * pointB.getY() - pointA.getY() * pointB.getX() + (pointA.getY() - pointB.getY()) * point.getX() + (pointB.getX() - pointA.getX()) * point.getY();

        if ((s < 0) != (t < 0)) {
            return false;
        }

        double area = -pointB.getY() * pointC.getX() + pointA.getY() * (pointC.getX() - pointB.getX()) + pointA.getX() * (pointB.getY() - pointC.getY()) + pointB.getX() * pointC.getY();

        return area < 0 ? (s <= 0 && s + t >= area) : (s >= 0 && s + t <= area);
    }

    /**
     * Check if the specified triangle is overlapping with this one.
     *
     * @param triangle - The specified triangle.
     * @return true if there is overlapping otherwise return false.
     */
    @Override
    public boolean isOverlapping(GwiseTriangle triangle) {

        boolean a = this.contains(triangle.pointA) || this.contains(triangle.pointB) || this.contains(triangle.pointC);
        boolean b = triangle.contains(pointA) || triangle.contains(pointB) || triangle.contains(pointC);
        return a || b;
    }
    
    public boolean isOverlapping(GwiseCircle circle) {
        
        GwisePoint p = circle.getCenter();
        
        double diaSquare = circle.getRadius() * circle.getRadius();
        
        if(contains(p)) {
            return true;
        }
        
        return getPointToLineSegmentDistance(circle.getCenter(), sideA) <= diaSquare || getPointToLineSegmentDistance(circle.getCenter(), sideB) <= diaSquare || getPointToLineSegmentDistance(circle.getCenter(), sideC) <= diaSquare;
    }
    
    @Override
    public double area() {
        
        double p = perimeter();
        
        double s = p * (p - sideA.perimeter())* (p - sideB.perimeter())* (p - sideC.perimeter());
        
        return Math.sqrt(s)/2;
    }
    
    @Override
    public double perimeter() {
        return sideA.perimeter() + sideB.perimeter() + sideC.perimeter();
    }
    
    private double getPointToLineSegmentDistance(GwisePoint point, GwiseLine line) {
        
        double a = point.getX() - line.getStartPoint().getX();  // position of point rel one end of line segment
        double b = point.getY() - line.getStartPoint().getY();  // vector along line
        double c = line.getStartPoint().getX() - line.getEndPoint().getX();
        double d = line.getStartPoint().getY() - line.getEndPoint().getY();
        double e = - d;
        double f = c;
        
        double dot = a*e + b*f; // orthogonal vector
        double len_sq = e*e + f*f;
        
        double m1 = dot / len_sq;  //The sqare of the distance between the point and the infinite line.
        
        double m2 = Double.min(point.getDistanceSquare(line.getStartPoint()), point.getDistanceSquare(line.getEndPoint()));
        
        return Math.sqrt(Double.min(m1, m2));
    }    
}
