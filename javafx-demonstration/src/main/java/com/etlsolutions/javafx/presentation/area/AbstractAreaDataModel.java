package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaMeasurement;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
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
    protected AreaType selectedAreaType;
    private double longitude;
    private double latitude;
    protected final ObservableList<AreaShape> areaShapes;
    protected AreaShape selectedAreaShape;
    protected final AreaMeasurementDataModel measurementDataModel;
    protected final ObservableListWrapperA<SubArea> subAreas;
    private SubArea selectedSubArea;

    public AbstractAreaDataModel(ObservableList<AreaType> areaTypes,  AreaMeasurement measurement) {
        this.areaTypes = areaTypes;
        selectedAreaType = areaTypes.get(0);
        areaShapes = new ObservableListWrapperA<>(selectedAreaType.getShapes());
        selectedAreaShape = areaShapes.get(0);
        this.measurementDataModel = new AreaMeasurementDataModel(measurement);
        subAreas = dataUnit == null ? new ObservableListWrapperA<SubArea>() : new ObservableListWrapperA<>(dataUnit.getAllSubAreas());
        selectedSubArea = subAreas.isEmpty() ? null : subAreas.get(0);
    }

    public ObservableList<AreaType> getAreaTypes() {
        return areaTypes;
    }

    public AreaType getSelectedAreaType() {
        return selectedAreaType;
    }

    public void setSelectedAreaType(AreaType selectedAreaType) {
        this.selectedAreaType = selectedAreaType;
    }

    public AreaMeasurementDataModel getMeasurementDataModel() {
        return measurementDataModel;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        double oldValue = this.longitude;
        this.longitude = longitude;
        support.firePropertyChange(LONGITUDE_PROPERTY, oldValue, this.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        double oldValue = this.latitude;
        this.latitude = latitude;
        support.firePropertyChange(LATITUDE_PROPERTY, oldValue, this.latitude);
    }

    public ObservableList<AreaShape> getAreaShapes() {
        return areaShapes;
    }

    public AreaShape getSelectedAreaShape() {
        return selectedAreaShape;
    }

    public void setSelectedAreaShape(AreaShape selectedAreaShape) {
        AreaShape oldValue = this.selectedAreaShape;
        this.selectedAreaShape = selectedAreaShape;
        support.firePropertyChange(AREA_SHAPE_TYPE_PROPERTY, oldValue, this.selectedAreaShape);
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

    @Override
    public void remove(RemoveEventId id) {
        
        if(Objects.equals(id, SELECTED_SUB_AREA_REMOVE_EVENT_ID)) {
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
