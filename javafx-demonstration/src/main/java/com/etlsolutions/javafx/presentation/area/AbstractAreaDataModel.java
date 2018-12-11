package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.AreaValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractAreaDataModel extends DataUnitFXMLDataModel<Area> implements MeasurementWrappable {

    public static final String LONGITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LONGITUDE_PROPERTY";
    public static final String LATITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LATITUDE_PROPERTY";
    public static final String AREA_SHAPE_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_TYPE_PROPERTY";
    public static final String AREA_SHAPE_VALUE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_VALUE_PROPERTY";

    public static final RemoveEventId SELECTED_SUB_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.area.AbstractAreaDataModel.SELECTED_SUB_AREA_REMOVE_EVENT_ID", "selected area part");

    protected final ObservableListWrapperA<AreaType> areaTypes;
    protected final ValueWrapper<AreaType> selectedAreaTypeValueWrapper;
    protected final ObservableListWrapperA<MeasurementType> areaShapes;
    protected AreaValueWrapper areaValueWrapper;
    protected ValueWrapper<MeasurementDataModel> measurementDataModelValueWrapper;
    protected final ObservableListWrapperA<SubArea> subAreas;
    private final ValueWrapper<SubArea> selectedSubArea;

    public AbstractAreaDataModel(ObservableListWrapperA<AreaType> areaTypes, Measurement measurement) {
        this.areaTypes = areaTypes;
        selectedAreaTypeValueWrapper = new ValueWrapper<>(areaTypes.get(0));
        areaShapes = new ObservableListWrapperA<>(MeasurementType.RECTANGLE, MeasurementType.SQUARE, MeasurementType.CIRCLE, MeasurementType.TRIANGLE, MeasurementType.IRREGULAR);
        areaValueWrapper = new AreaValueWrapper();
        measurementDataModelValueWrapper = new ValueWrapper<>(getMeasurementDataModel(measurement));
        subAreas = new ObservableListWrapperA<>();
        selectedSubArea = new ValueWrapper<>(null);
    }
    
    public AbstractAreaDataModel(Area area, ObservableListWrapperA<AreaType> areaTypes, Measurement measurement) {
        super(area);
        this.areaTypes = areaTypes;
        selectedAreaTypeValueWrapper = new ValueWrapper<>(areaTypes.get(0));
        areaShapes = new ObservableListWrapperA<>(MeasurementType.RECTANGLE, MeasurementType.SQUARE, MeasurementType.CIRCLE, MeasurementType.TRIANGLE, MeasurementType.IRREGULAR);
        areaValueWrapper = new AreaValueWrapper(area);
        measurementDataModelValueWrapper = new ValueWrapper<>(getMeasurementDataModel(measurement));
        subAreas = new ObservableListWrapperA<>(area.getAllSubAreas());
        selectedSubArea = new ValueWrapper<>(subAreas.isEmpty() ? null : subAreas.get(0));
    }
    
    private MeasurementDataModel getMeasurementDataModel(Measurement measurement) {
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

    public ObservableListWrapperA<AreaType> getAreaTypes() {
        return areaTypes;
    }

    public ValueWrapper<AreaType> getSelectedAreaTypeValueWrapper() {
        return selectedAreaTypeValueWrapper;
    }

    public ObservableListWrapperA<MeasurementType> getAreaShapes() {
        return areaShapes;
    }

    public AreaValueWrapper getAreaValueWrapper() {
        return areaValueWrapper;
    }
    
    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public ValueWrapper<SubArea> getSelectedSubArea() {
        return selectedSubArea;
    }

    @Override
    public ValueWrapper<MeasurementDataModel> getMeasurementDataModelValueWrapper() {
        return measurementDataModelValueWrapper;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, SELECTED_SUB_AREA_REMOVE_EVENT_ID)) {
            
            int index = subAreas.indexOf(selectedSubArea.getValue());            
            subAreas.remove(index);
            
            selectedSubArea.setValue(subAreas.isEmpty() ? null : subAreas.get(index == subAreas.size() ? index - 1 : index));
            return;
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/AreaFXML.fxml";
    }
}
