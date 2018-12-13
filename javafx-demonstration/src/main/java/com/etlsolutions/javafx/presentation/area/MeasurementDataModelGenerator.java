package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.CIRCLE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.IRREGULAR;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.RECTANGLE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.SQUARE;
import static com.etlsolutions.javafx.data.area.measurement.MeasurementType.TRIANGLE;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.area.subarea.BorderMeasurementDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.BoxDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.CirclePondDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.ContainerSetDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.IrregularPondDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.SquarePondDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.TrianglePondDataModel;

/**
 *
 * @author zc
 */
public class MeasurementDataModelGenerator {
    
    private static final MeasurementDataModelGenerator INSTANCE = new MeasurementDataModelGenerator();
    
    public static final MeasurementDataModelGenerator getInstance() {
        return INSTANCE;
    }

    public MeasurementDataModel getMeasurementDataModel(MeasurementType type) {
        switch (type) {
            case CIRCLE:
                return new CircleDataModel(new CircleMeasurement());
            case RECTANGLE:
                return new RectangleDataModel(new RectangleMeasurement());
            case IRREGULAR:
                return new AreaValueDataModel(new IrregularMeasurement());
            case TRIANGLE:
                return new TriangleDataModel(new TriangleMeasurement());
            case SQUARE:
                return new SquareDataModel(new SquareMeasurement());
            default:
                throw new IllegalArgumentException("Invalid measurement type.");
        }
    }

    
    public MeasurementDataModel getMeasurementDataModel(Measurement measurement) {
        switch (measurement.getType()) {
            case CIRCLE:
                return new CircleDataModel((CircleMeasurement) measurement);
            case RECTANGLE:
                return new RectangleDataModel((RectangleMeasurement) measurement);
            case IRREGULAR:
                return new AreaValueDataModel((IrregularMeasurement) measurement);
            case TRIANGLE:
                return new TriangleDataModel((TriangleMeasurement) measurement);
            case SQUARE:
                return new SquareDataModel((SquareMeasurement) measurement);
            default:
                throw new IllegalArgumentException("Invalid measurement type.");
        }
    }
    
    
    public MeasurementDataModel getMeasurementDataModel(SubAreaType type, Measurement measurement) {

        switch (type) {
            case BORDER:
                return new BorderMeasurementDataModel((BorderMeasurement) measurement);
            case CONTAINTER_SET:
                return new ContainerSetDataModel((ContainerSetMeasurement) measurement);
            case CUSTOM:
            case GREEN_HOUSE:
            case PLANT_BED:
            case LAWN:
                return getMeasurementDataModel(measurement);

            case POND:
                return getDepthMeasurementDataModel("Depth", measurement);
            case RAISED_PLANT_BED:
            case ROOM:
                return getDepthMeasurementDataModel("Height", measurement);

            default:
                throw new IllegalArgumentException("Invalid measurement.");
        }

    }


    private MeasurementDataModel getDepthMeasurementDataModel(String title, Measurement measurement) {
        switch (measurement.getType()) {
            case CIRCLE:
                return new CirclePondDataModel(title, (CircleMeasurement) measurement);
            case RECTANGLE:
                return new BoxDataModel(title, (RectangleMeasurement) measurement);
            case SQUARE:
                return new SquarePondDataModel(title, (SquareMeasurement) measurement);
            case TRIANGLE:
                return new TrianglePondDataModel(title, (TriangleMeasurement) measurement);
            case IRREGULAR:
                return new IrregularPondDataModel(title, (IrregularMeasurement) measurement);
            default:
                throw new IllegalArgumentException("Invalid measurement.");
        }
    }

}
