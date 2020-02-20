package com.etlsolutions.gwise.data.basicshape;

import com.etlsolutions.gwise.data.ValueWrapper;

/**
 * The GwisePoint class represents a single point in an area or subarea.
 *
 * @author ZhipengChang
 */
public final class GwisePoint {

    private final ValueWrapper<Double> xwrapper;
    private final ValueWrapper<Double> ywrapper;
    private final boolean jointPoint;

    public GwisePoint(double x, double y) {
        xwrapper = new ValueWrapper<>(x);
        ywrapper = new ValueWrapper<>(y);
        this.jointPoint = false;
    }
    
    public GwisePoint(double x, double y, boolean jointPoint) {
        xwrapper = new ValueWrapper<>(x);
        ywrapper = new ValueWrapper<>(y);
        this.jointPoint = jointPoint;
    }
    
    public GwisePoint(GwisePointBean bean) {
        this(bean.getX(), bean.getY(), false);
    }

    public double getX() {
        return xwrapper.getValue();
    }

    public void setX(double x) {
        xwrapper.setValue(x);
    }

    public ValueWrapper<Double> getXwrapper() {
        return xwrapper;
    }
    
    public double getY() {
        return xwrapper.getValue();
    }

    public void setY(double y) {
      ywrapper.setValue(y);
    }
    
    public ValueWrapper<Double> getYwrapper() {
        return ywrapper;
    }
            
    public boolean isJointPoint() {
        return jointPoint;
    }

    public double distance(GwisePoint point) {
        
        return Math.sqrt(distanceSquare(point));
        
    }
    
    public double distanceSquare(GwisePoint point) {
        return (this.getX() - point.getX()) * (this.getX() - point.getX()) + (this.getY() - point.getY()) * (this.getY() - point.getY());
    }

    public boolean onLeftOf(GwisePoint point) {
        return this.getX() < point.getX();
    }

    public boolean onTopOf(GwisePoint point) {
        return this.getY() < point.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.getX()) ^ (Double.doubleToLongBits(this.getX()) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.getY()) ^ (Double.doubleToLongBits(this.getY()) >>> 32));
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
        if (Double.doubleToLongBits(this.getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        }

        return Double.doubleToLongBits(this.getY()) == Double.doubleToLongBits(other.getY());
    }

    @Override
    public String toString() {
        return "GwisePoint{" + "x=" + getX() + ", y=" + getY() + '}';
    }
}
