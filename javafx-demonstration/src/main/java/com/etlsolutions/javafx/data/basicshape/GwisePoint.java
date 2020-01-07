package com.etlsolutions.javafx.data.basicshape;

/**
 * The GwisePoint class represents a single point in the area.
 *
 * @author ZhipengChang
 */
public class GwisePoint implements GwiseShape {

    private double x;
    private double y;
    private boolean jointPoint;

    public GwisePoint() {
    }

    public GwisePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public boolean isJointPoint() {
        return jointPoint;
    }

    public void setJointPoint(boolean jointPoint) {
        this.jointPoint = jointPoint;
    }
    
    public double getDistance(GwisePoint point) {
        
        return Math.sqrt(getDistanceSquare(point));
        
    }
    
    public double getDistanceSquare(GwisePoint point) {
        return (this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y);
    }

    public boolean isOnLeftOf(GwisePoint point) {
        return this.x < point.x;
    }

    public boolean isOnTopOf(GwisePoint point) {
        return this.y < point.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final GwisePoint other = (GwisePoint) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }

        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }

    @Override
    public String toString() {
        return "GwisePoint{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
