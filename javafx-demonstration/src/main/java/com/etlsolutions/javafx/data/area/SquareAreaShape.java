package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public class SquareAreaShape extends AreaShape {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        area = this.side * this.side;
    }
    
    @Override
    public AreaShapeType getType() {
        return AreaShapeType.SQURE;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.side) ^ (Double.doubleToLongBits(this.side) >>> 32));
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
        final SquareAreaShape other = (SquareAreaShape) obj;
        return Double.doubleToLongBits(this.side) == Double.doubleToLongBits(other.side);
    }
}
