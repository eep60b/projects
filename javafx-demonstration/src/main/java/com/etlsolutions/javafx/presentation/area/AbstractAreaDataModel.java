package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaMeasurement;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.collections.ObservableList;

/**
 *
 * @author Zhipeng
 */
public abstract class AbstractAreaDataModel extends DataUnitFXMLDataModel {

    public static final String LONGITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LONGITUDE_PROPERTY";
    public static final String LATITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LATITUDE_PROPERTY";
    public static final String AREA_SHAPE_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_TYPE_PROPERTY";
    public static final String AREA_SHAPE_VALUE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_VALUE_PROPERTY";

    protected Area area;
    protected final ObservableList<AreaType> areaTypes;
    protected AreaType selectedAreaType;
    private double longitude;
    private double latitude;
    protected final ObservableList<AreaShape> areaShapes;
    protected AreaShape selectedAreaShape;
    protected final AreaMeasurement measurement;

    public AbstractAreaDataModel(ObservableList<AreaType> areaTypes,  AreaMeasurement measurement) {
        this.areaTypes = areaTypes;
        selectedAreaType = areaTypes.get(0);
        areaShapes = new ObservableListWrapperA<>(selectedAreaType.getShapes());
        selectedAreaShape = areaShapes.get(0);
        this.measurement = measurement;
    }

    public Area getArea() {
        return area;
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

    public AreaMeasurement getMeasurement() {
        return measurement;
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

    @Override
    public String getFxmlPath() {
        return "/fxml/area/AreaFXML.fxml";
    }
}
