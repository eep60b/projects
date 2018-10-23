package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;
import com.etlsolutions.javafx.data.area.subarea.SubAreaShape;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class AbstractSubAreaDataModel extends DataUnitFXMLDataModel {

 
    protected SubArea subArea;
    protected final ObservableListWrapperA<SubAreaType> subAreaTypes;
    protected SubAreaType selectedSubAreaType;
    protected final ObservableListWrapperA<SubAreaShape> subAreaShapes;
    protected SubAreaShape selectedSubAreaShape;
    protected final SubAreaMeasurementDataModel measurementDataModel;

    public AbstractSubAreaDataModel(SubAreaType[] subAreaTypes, SubAreaMeasurement measurement) {   
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaType = this.subAreaTypes.get(0);
        subAreaShapes = new ObservableListWrapperA<>(selectedSubAreaType.getShapes());
        selectedSubAreaShape = subAreaShapes.get(0);
        measurementDataModel = new SubAreaMeasurementDataModel(measurement);
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public ObservableList<SubAreaType> getSubAreaTypes() {
        return subAreaTypes;
    }

    public SubAreaType getSelectedSubAreaType() {
        return selectedSubAreaType;
    }

    public void setSelectedSubAreaType(SubAreaType selectedSubAreaType) {
        this.selectedSubAreaType = selectedSubAreaType;
        subAreaShapes.clear();
        subAreaShapes.addAll(this.selectedSubAreaType.getShapes());
        setSelectedSubAreaShape(subAreaShapes.get(0));
    }

    public ObservableList<SubAreaShape> getShapes() {
        return subAreaShapes;
    }

    public SubAreaShape getSelectedSubAreaShape() {
        return selectedSubAreaShape;
    }

    public void setSelectedSubAreaShape(SubAreaShape selectedSubAreaShape) {
        this.selectedSubAreaShape = selectedSubAreaShape;
    }

    public SubAreaMeasurementDataModel getMeasurementDataModel() {
        return measurementDataModel;
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/SubAreaFXML.fxml";
    }
}
