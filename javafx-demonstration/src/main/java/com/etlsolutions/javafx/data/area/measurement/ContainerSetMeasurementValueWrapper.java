package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.gwise.data.ValueWrapper;

/**
 *
 * @author zc
 */
public class ContainerSetMeasurementValueWrapper extends DoubleValueWrapper implements MeasurementValueWrapper {

    private final ValueWrapper<Integer> numberValueWrapper;
    private final ValueWrapper<String> volumeValueWrapper;
    private final ValueWrapper<String> heightValueWrapper;

    public ContainerSetMeasurementValueWrapper(ContainerSetMeasurement measurement) {
        numberValueWrapper = new ValueWrapper<>(measurement.getNumber());
        volumeValueWrapper = getWrapper(measurement.getVolume());
        heightValueWrapper = getWrapper(measurement.getHeight());        
    }
    
    public ContainerSetMeasurementValueWrapper() {
        this(new ContainerSetMeasurement());
    }    

    public ValueWrapper<Integer> getNumberValueWrapper() {
        return numberValueWrapper;
    }

    public ValueWrapper<String> getHeightValueWrapper() {
        return heightValueWrapper;
    }

    public double getHeight() {
        return getValue(heightValueWrapper);
    } 
    
    public ValueWrapper<String> getVolumeValueWrapper() {
        return volumeValueWrapper;
    }

    public double getVolume() {
        return getValue(volumeValueWrapper);
    }
   
    @Override
    public ValueWrapper<MeasurementType> getTypeValueWrapper() {
        return new ValueWrapper<>(MeasurementType.NUMBER);
    }

    @Override
    public Measurement getMeasurement() {
        return new ContainerSetMeasurement(this);
    }
}
