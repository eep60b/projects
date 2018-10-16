package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public class RectAngleAreaShape extends AreaShape {

    private double length;
    private double width;

    @Override
    public AreaShapeType getType() {
        return AreaShapeType.RECTANGLE;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
        areaValue = this.width * this.length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        areaValue = this.width * this.length;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
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
        final RectAngleAreaShape other = (RectAngleAreaShape) obj;
        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {
            return false;
        }
        return Double.doubleToLongBits(this.width) == Double.doubleToLongBits(other.width);
    }
}
