package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.javafx.presentation.DetailDataModelGenerator;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.AreaValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import java.util.Objects;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractAreaDataModel extends DataUnitFXMLDataModel<Area> implements FXMLContentActionDataModel<MeasurementDataModel> {

    public static final String LONGITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LONGITUDE_PROPERTY";
    public static final String LATITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LATITUDE_PROPERTY";
    public static final String AREA_SHAPE_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_TYPE_PROPERTY";
    public static final String AREA_SHAPE_VALUE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_VALUE_PROPERTY";

    public static final RemoveEventId SELECTED_SUB_AREA_REMOVE_EVENT_ID = new RemoveEventId("com.etlsolutions.javafx.presentation.menu.add.area.AbstractAreaDataModel.SELECTED_SUB_AREA_REMOVE_EVENT_ID", "selected area part");

    protected final ObservableListWrapperA<AreaType> areaTypes;
    protected final ValueWrapper<AreaType> selectedAreaTypeValueWrapper;
    protected final ObservableListWrapperA<MeasurementType> measurementTypes;
    private final AreaValueWrapper areaValueWrapper;
    protected MeasurementDataModel measurementDataModel;
    protected final ObservableListWrapperA<SubArea> subAreas;
    private final ValueWrapper<SubArea> selectedSubArea;

    public AbstractAreaDataModel(AreaValueWrapper areaValueWrapper, ObservableListWrapperA<AreaType> areaTypes, Measurement measurement) {
        this.areaTypes = areaTypes;
        selectedAreaTypeValueWrapper = new ValueWrapper<>(areaTypes.get(0));
        measurementTypes = new ObservableListWrapperA<>(MeasurementType.RECTANGLE, MeasurementType.SQUARE, MeasurementType.CIRCLE, MeasurementType.TRIANGLE, MeasurementType.IRREGULAR);
        this.areaValueWrapper = areaValueWrapper;
        measurementDataModel = DetailDataModelGenerator.getInstance().getMeasurementDataModel(measurement);
        subAreas = new ObservableListWrapperA<>();
        selectedSubArea = new ValueWrapper<>(null);
    }

    public AbstractAreaDataModel(Area area, ObservableListWrapperA<AreaType> areaTypes, Measurement measurement) {
        set(area);
        this.areaTypes = areaTypes;
        selectedAreaTypeValueWrapper = new ValueWrapper<>(areaTypes.get(0));
        measurementTypes = new ObservableListWrapperA<>(MeasurementType.RECTANGLE, MeasurementType.SQUARE, MeasurementType.CIRCLE, MeasurementType.TRIANGLE, MeasurementType.IRREGULAR);
        areaValueWrapper = new AreaValueWrapper(area);
        measurementDataModel = DetailDataModelGenerator.getInstance().getMeasurementDataModel(measurement);
        subAreas = new ObservableListWrapperA<>(area.getSubAreas());
        selectedSubArea = new ValueWrapper<>(subAreas.isEmpty() ? null : subAreas.get(0));
    }

    public ObservableListWrapperA<AreaType> getAreaTypes() {
        return areaTypes;
    }

    public ValueWrapper<AreaType> getSelectedAreaTypeValueWrapper() {
        return selectedAreaTypeValueWrapper;
    }

    public ObservableListWrapperA<MeasurementType> getMeasurementTypes() {
        return measurementTypes;
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
    public MeasurementDataModel getContentModel() {
        return measurementDataModel;
    }

    @Override
    public void setContentModel(MeasurementDataModel measurementDataModel) {
        this.measurementDataModel = measurementDataModel;
    }

    @Override
    protected  AreaValueWrapper getValueWrapper() {
        return areaValueWrapper;
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
