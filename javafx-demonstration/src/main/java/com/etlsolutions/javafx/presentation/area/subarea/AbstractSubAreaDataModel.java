package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementFactory;
import com.etlsolutions.javafx.data.area.measurement.MeasurementType;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.data.area.subarea.SubAreaValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLContentActionDataModel;
import com.etlsolutions.javafx.presentation.area.MeasurementDataModel;
import com.etlsolutions.javafx.presentation.DetailDataModelGenerator;
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
    private final SubAreaValueWrapper subAreaValueWrapper;

    public AbstractSubAreaDataModel(SubAreaValueWrapper subAreaValueWrapper, SubAreaType[] subAreaTypes) {
        this.subAreaValueWrapper = subAreaValueWrapper;
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaTypeValueWrapper = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(selectedSubAreaTypeValueWrapper.getValue().getShapes());
        Measurement measurement = MeasurementFactory.getInstance().getDefaultAreaMeasurement(subAreaTypes[0]);
        measurementDataModel =  DetailDataModelGenerator.getInstance().getMeasurementDataModel(selectedSubAreaTypeValueWrapper.getValue(), measurement);
    }
    

    public AbstractSubAreaDataModel(SubAreaValueWrapper subAreaValueWrapper, SubArea subArea, SubAreaType[] subAreaTypes, Measurement measurement) {
        this.subAreaValueWrapper = subAreaValueWrapper;
        set(subArea);
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaTypeValueWrapper = new ValueWrapper<>(this.subAreaTypes.get(0));
        subAreaShapes = new ObservableListWrapperA<>(MeasurementType.values());

        measurementDataModel = DetailDataModelGenerator.getInstance().getMeasurementDataModel(selectedSubAreaTypeValueWrapper.getValue(), measurement);
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
    protected SubAreaValueWrapper getValueWrapper() {
        return subAreaValueWrapper;
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
