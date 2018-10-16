package com.etlsolutions.javafx.data.area;

/**
 *
 * @author zc
 */
public class IrregularAreaShape extends AreaShape {

    public void setAreaValue(double areaValue) {
        this.areaValue = areaValue;
    }
    
    @Override
    public AreaShapeType getType() {
        return AreaShapeType.IRREGULAR;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.areaValue) ^ (Double.doubleToLongBits(this.areaValue) >>> 32));
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
        final IrregularAreaShape other = (IrregularAreaShape) obj;
        return Double.doubleToLongBits(this.areaValue) == Double.doubleToLongBits(other.areaValue);
    }
}
