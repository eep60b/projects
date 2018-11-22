package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class ContainterMeasurementValueWrapper extends DoubleValueWrapper implements LocationSpecialValueWrapper {

    private final ValueWrapper<String> shapeValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;
    private final ValueWrapper<String> volumeValueWrapper;



    public ContainterMeasurementValueWrapper(ContainerMeasurement measurement) {
        shapeValueWrapper = new ValueWrapper<>(measurement.getShape());
        heightValueWrapper = getWrapper(measurement.getHeight());
        volumeValueWrapper = getWrapper(measurement.getVolume());
    }
    
    public ContainterMeasurementValueWrapper() {
        this(new ContainerMeasurement());
    }

    public ValueWrapper<String> getShapeValueWrapper() {
        return shapeValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    public ValueWrapper<String> getVolumeValueWrapper() {
        return volumeValueWrapper;
    }
    
    public double getHeight() {
        return getValue(heightValueWrapper);
    }

    public double getVolume() {
        return getValue(volumeValueWrapper);
    }

    @Override
    public ValueWrapper<LocationMeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(LocationMeasurementType.CONTAINER);
    }

    @Override
    public ContainerMeasurement getMeasurement() {
        return new ContainerMeasurement(this);
    }
}
