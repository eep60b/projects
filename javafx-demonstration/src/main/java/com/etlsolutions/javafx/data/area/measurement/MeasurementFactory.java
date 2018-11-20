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

    public Measurement getMeasurement(MeasurementValueWrapper measurementValueWrapper) {
        switch (measurementValueWrapper.getType().getValue()) {
            case BORDER:
                return new BorderMeasurement((BorderMeasurementValueWrapper) measurementValueWrapper);
            case CIRCLE:
                return new CircleMeasurement((CircleMeasurementValueWrapper) measurementValueWrapper);
            default:
                throw new IllegalArgumentException("Invalid measuerment type.");
        }
    }

}
