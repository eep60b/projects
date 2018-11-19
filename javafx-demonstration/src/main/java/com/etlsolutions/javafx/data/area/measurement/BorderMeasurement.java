package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class BorderMeasurement implements Measurement {

    private double length;
    private double width;
    
    @Override
    public MeasurementType getType() {
        return MeasurementType.BORDER;
    }
    
}
