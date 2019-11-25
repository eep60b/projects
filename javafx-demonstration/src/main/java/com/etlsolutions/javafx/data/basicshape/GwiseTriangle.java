package com.etlsolutions.javafx.data.basicshape;

/**
 *
 * @author ZhipengChang
 */
public class GwiseTriangle implements GwiseShape {

    private final GwisePoint pointA;
    private final GwisePoint pointB;
    private final GwisePoint pointC;

    private final GwiseLine sideA;
    private final GwiseLine sideB;
    private final GwiseLine sideC;

    public GwiseTriangle(GwisePoint p1, GwisePoint p2, GwisePoint p3) {
        pointA = p1;
        pointB = p2;
        pointC = p3;

        sideA = new GwiseLine(pointB, pointC);
        sideB = new GwiseLine(pointC, pointA);
        sideC = new GwiseLine(pointA, pointB);
    }

    public GwisePoint getPointA() {
        return pointA;
    }

    public GwisePoint getPointB() {
        return pointB;
    }

    public GwisePoint getPointC() {
        return pointC;
    }

    public GwiseLine getSideA() {
        return sideA;
    }

    public GwiseLine getSideB() {
        return sideB;
    }

    public GwiseLine getSideC() {
        return sideC;
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
        
        return p.getDistanceSquare(pointA) <= diaSquare || p.getDistanceSquare(pointB) <= diaSquare ||p.getDistanceSquare(pointC) <= diaSquare;
    }
    
    @Override
    public double getArea() {
        
        double p = getPerimeter();
        
        double s = p * (p - sideA.getPerimeter())* (p - sideB.getPerimeter())* (p - sideC.getPerimeter());
        
        return Math.sqrt(s)/2;
    }
    
    @Override
    public double getPerimeter() {
        return sideA.getPerimeter() + sideB.getPerimeter() + sideC.getPerimeter();
    }
}
