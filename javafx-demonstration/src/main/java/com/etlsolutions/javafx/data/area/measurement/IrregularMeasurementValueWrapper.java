/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class IrregularMeasurementValueWrapper extends DoubleValueWrapper implements MeasurementValueWrapper {
    
    private final ValueWrapper<String> areaValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public IrregularMeasurementValueWrapper(IrregularMeasurement measurement) {
        areaValueWrapper = getWrapper(measurement.getArea());
        heightValueWrapper = getWrapper(measurement.getHeight());
    }

    public IrregularMeasurementValueWrapper() {
        this(new IrregularMeasurement());
    }

    public ValueWrapper<String> getAreaValueWrapper() {
        return areaValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }
    
    public double getArea() {
        return getValue(areaValueWrapper);
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    @Override
    public MeasurementType getType() {
        return MeasurementType.IRREGULAR;
    }
}
