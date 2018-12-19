package com.etlsolutions.javafx.data.area.measurement;

import com.etlsolutions.javafx.data.area.subarea.SubAreaType;

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

    public Measurement getDefaultAreaMeasurement(SubAreaType subAreaType) {
        switch (subAreaType.getShapes()[0]) {
            case BORDER:
                return new BorderMeasurement();
            case CIRCLE:
                return new CircleMeasurement();
            case IRREGULAR:
                return new IrregularMeasurement();
            case RECTANGLE:
                return new RectangleMeasurement();
            case SQUARE:
                return new SquareMeasurement();
            case TRIANGLE:
                return new TriangleMeasurement();
            case NUMBER:
                return new ContainerSetMeasurement();
            default:
                throw new IllegalArgumentException("Invalid measuerment type.");
        }
    }

}
