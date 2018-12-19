package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementFactory;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModelGenerator;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class AbstractSubAreaDataModel extends DataUnitFXMLDataModel<SubArea>  implements FXMLContentActionDataModel<MeasurementDataModel> {

    protected final ObservableListWrapperA<SubAreaType> subAreaTypes;
    protected final ValueWrapper<SubAreaType> selectedSubAreaTypeValueWrapper;
    protected final ObservableListWrapperA<MeasurementType> subAreaShapes;
    protected MeasurementDataModel measurementDataModel;

    public AbstractSubAreaDataModel(SubAreaType[] subAreaTypes) {
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaTypeValueWrapper = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(selectedSubAreaTypeValueWrapper.getValue().getShapes());
        Measurement measurement = MeasurementFactory.getInstance().getDefaultAreaMeasurement(subAreaTypes[0]);
        measurementDataModel =  MeasurementDataModelGenerator.getInstance().getMeasurementDataModel(selectedSubAreaTypeValueWrapper.getValue(), measurement);
    }
    

    public AbstractSubAreaDataModel(SubArea subArea, SubAreaType[] subAreaTypes, Measurement measurement) {
        super(subArea);
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaTypeValueWrapper = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(MeasurementType.values());

        measurementDataModel = MeasurementDataModelGenerator.getInstance().getMeasurementDataModel(selectedSubAreaTypeValueWrapper.getValue(), measurement);
    }

    public ObservableList<SubAreaType> getSubAreaTypes() {
        return subAreaTypes;
    }

    public ValueWrapper<SubAreaType> getSelectedSubAreaTypeValueWrapper() {
        return selectedSubAreaTypeValueWrapper;
    }

    public ObservableListWrapperA<MeasurementType> getSubAreaShapes() {
        return subAreaShapes;
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
    public String getFxmlPath() {
        return "/fxml/area/SubAreaFXML.fxml";
    }
}
