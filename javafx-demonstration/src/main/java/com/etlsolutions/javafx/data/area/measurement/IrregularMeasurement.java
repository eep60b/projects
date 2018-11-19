package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;

/**
 *
 * @author zc
 */
public class IrregularMeasurement extends DoubleValueWrapper implements Measurement {

    private double area;
    private double height;

    public IrregularMeasurement() {

    }

    public IrregularMeasurement(IrregularMeasurementValueWrapper wrapper) {
        area = wrapper.getArea();
        height = wrapper.getHeight();
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.IRREGULAR;
    }
}
