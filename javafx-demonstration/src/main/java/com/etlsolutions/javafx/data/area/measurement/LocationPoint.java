package com.etlsolutions.javafx.data.area.measurement;

/**
 * The LocationPoint class is used for the custom area and border to record the
 * occupied points. The length unit will be cm. Any other units such metre and
 * inch will be converted into cm before the LocationPoint object created. The
 * maximum X, Y numbers will be (9999, 9999).
 *
 * @author zc
 */
public class LocationPoint implements Comparable<LocationPoint> {

    private final int x;
    private final int y;

    public LocationPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (53 * 3 + x) * 53 + y;
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

        final LocationPoint other = (LocationPoint) obj;

        if (this.x != other.x) {
            return false;
        }

        return this.y == other.y;
    }

    @Override
    public int compareTo(LocationPoint o) {

        return getX() == o.getX() ? getY() - o.getY() : getX() - o.getX();
    }
}
