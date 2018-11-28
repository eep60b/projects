package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.BorderMeasurement;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.measurement.ContainerSetMeasurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.area.AreaValueDataModel;
import com.etlsolutions.javafx.presentation.area.CircleDataModel;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;
import com.etlsolutions.javafx.presentation.area.MeasurementWrappable;
import com.etlsolutions.javafx.presentation.area.RectangleDataModel;
import com.etlsolutions.javafx.presentation.area.SquareDataModel;
import com.etlsolutions.javafx.presentation.area.TriangleDataModel;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class AbstractSubAreaDataModel extends DataUnitFXMLDataModel<SubArea>  implements MeasurementWrappable {

    protected final ObservableListWrapperA<SubAreaType> subAreaTypes;
    protected final ValueWrapper<SubAreaType> selectedSubAreaType;
    protected final ObservableListWrapperA<MeasurementType> subAreaShapes;
    protected final ValueWrapper<MeasurementDataModel> measurementDataModel;

    public AbstractSubAreaDataModel(SubAreaType[] subAreaTypes, Measurement measurement) {
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaType = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(MeasurementType.values());

        measurementDataModel = new ValueWrapper<>(getMeasurementDataModel(selectedSubAreaType.getValue(), measurement));
    }
    

    public AbstractSubAreaDataModel(SubArea subArea, SubAreaType[] subAreaTypes, Measurement measurement) {
        super(subArea);
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaType = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(MeasurementType.values());

        measurementDataModel = new ValueWrapper<>(getMeasurementDataModel(selectedSubAreaType.getValue(), measurement));
    }

    private MeasurementDataModel getMeasurementDataModel(SubAreaType type, Measurement measurement) {

        switch (type) {
            case BORDER:
                return new BorderMeasurementDataModel((BorderMeasurement) measurement);
            case CONTAINTER_SET:
                return new ContainerSetDataModel((ContainerSetMeasurement) measurement);
            case CUSTOM:
            case GREEN_HOUSE:
            case PLANT_BED:
            case LAWN:
                return getFlatMeasurementDataModel(measurement);

            case POND:
                return getDepthMeasurementDataModel("Depth", measurement);
            case RAISED_PLANT_BED:
            case ROOM:
                return getDepthMeasurementDataModel("Height", measurement);

            default:
                throw new IllegalArgumentException("Invalid measurement.");
        }

    }

    private MeasurementDataModel getFlatMeasurementDataModel(Measurement measurement) {

        switch (measurement.getType()) {
            case CIRCLE:
                return new CircleDataModel((CircleMeasurement) measurement);
            case RECTANGLE:
                return new RectangleDataModel((RectangleMeasurement) measurement);
            case SQUARE:
                return new SquareDataModel((SquareMeasurement) measurement);
            case TRIANGLE:
                return new TriangleDataModel((TriangleMeasurement) measurement);
            case IRREGULAR:
                return new AreaValueDataModel((IrregularMeasurement) measurement);
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

    public ObservableList<SubAreaType> getSubAreaTypes() {
        return subAreaTypes;
    }

    public ValueWrapper<SubAreaType> getSelectedSubAreaType() {
        return selectedSubAreaType;
    }

    public ObservableListWrapperA<MeasurementType> getSubAreaShapes() {
        return subAreaShapes;
    }

    @Override
    public ValueWrapper<MeasurementDataModel> getMeasurementDataModelValueWrapper() {
        return measurementDataModel;
    }
    
    @Override
    public String getFxmlPath() {
        return "/fxml/area/SubAreaFXML.fxml";
    }
}
