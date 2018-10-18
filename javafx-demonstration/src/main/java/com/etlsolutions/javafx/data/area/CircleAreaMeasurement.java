package com.etlsolutions.javafx.data.area;

import static com.etlsolutions.javafx.system.SettingConstants.PI;

/**
 *
 * @author zc
 */
public class CircleAreaMeasurement extends AreaMeasurement {

    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        areaValue = (this.diameter / 2) * this.diameter / 2 * PI;
    }

    @Override
    public AreaShape getType() {

        return AreaShape.CIRCLE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.diameter) ^ (Double.doubleToLongBits(this.diameter) >>> 32));
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
        final CircleAreaMeasurement other = (CircleAreaMeasurement) obj;
        return Double.doubleToLongBits(this.diameter) == Double.doubleToLongBits(other.diameter);
    }

}
