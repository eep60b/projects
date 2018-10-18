package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public class SquareAreaMeasurement extends AreaMeasurement {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        areaValue = this.side * this.side;
    }
    
    @Override
    public AreaShape getType() {
        return AreaShape.SQURE;
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
        final SquareAreaMeasurement other = (SquareAreaMeasurement) obj;
        return Double.doubleToLongBits(this.side) == Double.doubleToLongBits(other.side);
    }
}
