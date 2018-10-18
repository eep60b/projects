package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
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

    public static final String SUB_AREA_SHAPE_PROPERTY = "com.etlsolutions.javafx.presentation.area.subarea.AbstractSubAreaDataModel.SUB_AREA_SHAPE_PROPERTY";
    public static final String SUB_AREA_MEASUREMENT_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.SUB_AREA_MEASUREMENT_PROPERTY";

    protected Area area;
    protected SubArea subArea;
    protected final ObservableListWrapperA<SubAreaType> subAreaTypes;
    protected SubAreaType selectedSubAreaType;
    protected final ObservableListWrapperA<SubAreaShape> subAreaShapes;
    protected SubAreaShape selectedSubAreaShape;
    protected SubAreaMeasurement measurement;

    public AbstractSubAreaDataModel(Area area, SubAreaType... subAreaTypes) {
        this.area = area;
        this.subAreaTypes = new ObservableListWrapperA<>(subAreaTypes);
        selectedSubAreaType = this.subAreaTypes.get(0);
        subAreaShapes = new ObservableListWrapperA<>(selectedSubAreaType.getShapes());
        selectedSubAreaShape = subAreaShapes.get(0);
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public ObservableList<SubAreaType> getAreaTypes() {
        return subAreaTypes;
    }

    public SubAreaType getSelectedSubAreaType() {
        return selectedSubAreaType;
    }

    public void setSelectedSubAreaType(SubAreaType selectedSubAreaType) {
        this.selectedSubAreaType = selectedSubAreaType;
    }

    public ObservableList<SubAreaShape> getAreaShapeTypes() {
        return subAreaShapes;
    }

    public SubAreaShape getSelectedSubAreaShape() {
        return selectedSubAreaShape;
    }

    public void setSelectedSubAreaShape(SubAreaShape selectedSubAreaShape) {
        SubAreaShape oldValue = this.selectedSubAreaShape;
        this.selectedSubAreaShape = selectedSubAreaShape;
        support.firePropertyChange(SUB_AREA_SHAPE_PROPERTY, oldValue, this.selectedSubAreaShape);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/SubAreaFXML.fxml";
    }
}
