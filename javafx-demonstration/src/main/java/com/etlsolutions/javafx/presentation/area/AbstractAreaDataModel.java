package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.AreaValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.CircleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.IrregularMeasurement;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.RectangleMeasurement;
import com.etlsolutions.javafx.data.area.measurement.SquareMeasurement;
import com.etlsolutions.javafx.data.area.measurement.TriangleMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import java.util.Objects;
import javafx.collections.ObservableList;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractAreaDataModel extends DataUnitFXMLDataModel<Area> {

    public static final String LONGITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LONGITUDE_PROPERTY";
    public static final String LATITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LATITUDE_PROPERTY";
    public static final String AREA_SHAPE_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_TYPE_PROPERTY";
    public static final String AREA_SHAPE_VALUE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_VALUE_PROPERTY";

    public static final RemoveEventId SELECTED_SUB_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.area.AbstractAreaDataModel.SELECTED_SUB_AREA_REMOVE_EVENT_ID", "selected area part");

    protected final ObservableList<AreaType> areaTypes;
    protected final ValueWrapper<AreaType> selectedAreaTypeValueWrapper;
    protected final ObservableList<AreaShape> areaShapes;
    protected AreaValueWrapper areaValueWrapper;
    protected ValueWrapper<MeasurementDataModel> measurementDataModelValueWrapper;
    protected final ObservableListWrapperA<SubArea> subAreas;
    private SubArea selectedSubArea;

    public AbstractAreaDataModel(ObservableList<AreaType> areaTypes, Measurement measurement) {
        this.areaTypes = areaTypes;
        selectedAreaTypeValueWrapper = new ValueWrapper<>(areaTypes.get(0));
        areaShapes = new ObservableListWrapperA<>(selectedAreaTypeValueWrapper.getValue().getShapes());
        areaValueWrapper = dataUnit == null ? new AreaValueWrapper() : new AreaValueWrapper(dataUnit);
        measurementDataModelValueWrapper = new ValueWrapper<>(getMeasurementDataModel(measurement));
        subAreas = dataUnit == null ? new ObservableListWrapperA<SubArea>() : new ObservableListWrapperA<>(dataUnit.getAllSubAreas());
        selectedSubArea = subAreas.isEmpty() ? null : subAreas.get(0);
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

    public ObservableList<AreaType> getAreaTypes() {
        return areaTypes;
    }

    public ValueWrapper<AreaType> getSelectedAreaTypeValueWrapper() {
        return selectedAreaTypeValueWrapper;
    }

    public ObservableList<AreaShape> getAreaShapes() {
        return areaShapes;
    }

    public AreaValueWrapper getAreaValueWrapper() {
        return areaValueWrapper;
    }
    
    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public SubArea getSelectedSubArea() {
        return selectedSubArea;
    }

    public void setSelectedSubArea(SubArea selectedSubArea) {
        this.selectedSubArea = selectedSubArea;
    }

    public ValueWrapper<MeasurementDataModel> getMeasurementDataModelValueWrapper() {
        return measurementDataModelValueWrapper;
    }

    @Override
    public void remove(RemoveEventId id) {

        if (Objects.equals(id, SELECTED_SUB_AREA_REMOVE_EVENT_ID)) {
            subAreas.remove(selectedSubArea);
            return;
        }

        super.remove(id);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/AreaFXML.fxml";
    }
}
