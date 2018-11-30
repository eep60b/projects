package com.etlsolutions.javafx.data.area.measurement;

/**
 *
 * @author zc
 */
public class MeasurementFactory {
    
    private static final MeasurementFactory INSTANCE = new MeasurementFactory();
    
    private MeasurementFactory() {
        
    }
    
    public static MeasurementFactory getInstance() {
        return INSTANCE;
    }
    
    public Measurement getAreaMeasurement(MeasurementValueWrapper measurementValueWrapper) {
        switch (measurementValueWrapper.getTypeValueWrapper().getValue()) {
            case BORDER:
                return new BorderMeasurement((BorderMeasurementValueWrapper) measurementValueWrapper);
            case CIRCLE:
                return new CircleMeasurement((CircleMeasurementValueWrapper) measurementValueWrapper);
            case IRREGULAR:
                return new IrregularMeasurement((IrregularMeasurementValueWrapper) measurementValueWrapper);
            case RECTANGLE:
                return new RectangleMeasurement((RectangleMeasurementValueWrapper) measurementValueWrapper);
            case SQUARE:
                return new SquareMeasurement((SquareMeasurementValueWrapper) measurementValueWrapper);
            case TRIANGLE:
                return new TriangleMeasurement((TriangleMeasurementValueWrapper) measurementValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid measuerment type.");
        }
    }
    
}
