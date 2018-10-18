package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public class TriangleAreaMeasurement extends AreaMeasurement {

    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        calculateArea();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        calculateArea();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        calculateArea();
    }

    private void calculateArea() {

        double mean = (a + b + c) / 2;

        areaValue = Math.sqrt(mean * (mean - a) * (mean - b) * (mean - c));

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
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
        final TriangleAreaMeasurement other = (TriangleAreaMeasurement) obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
            return false;
        }
        return Double.doubleToLongBits(this.c) == Double.doubleToLongBits(other.c);
    }

    @Override
    public AreaShape getType() {
        return AreaShape.TRIANGLE;
    }
}
