package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaMeasurement;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.CircleAreaMeasurement;
import com.etlsolutions.javafx.data.area.IrregularAreaMeasurement;
import com.etlsolutions.javafx.data.area.RectAngleAreaMeasurement;
import com.etlsolutions.javafx.data.area.SquareAreaMeasurement;
import com.etlsolutions.javafx.data.area.TriangleAreaMeasurement;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import java.util.Arrays;
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
    protected final ObservableList<AreaShape> areaShapeTypes;
    protected AreaShape selectedAreaShapeType;
    private final RectAngleAreaMeasurement rectAngleAreaMeasurement;
    private final SquareAreaMeasurement squareAreaMeasurement;
    private final CircleAreaMeasurement circleAreaMeasurement;
    private final TriangleAreaMeasurement triangleAreaMeasurement;
    private final IrregularAreaMeasurement irregularAreaMeasurement;

    public AbstractAreaDataModel(ObservableList<AreaType> areaTypes) {
        this.areaTypes = areaTypes;
        areaShapeTypes = new ObservableListWrapperA<>(Arrays.asList(AreaShape.values()));
        rectAngleAreaMeasurement = new RectAngleAreaMeasurement();
        squareAreaMeasurement = new SquareAreaMeasurement();
        circleAreaMeasurement = new CircleAreaMeasurement();
        triangleAreaMeasurement = new TriangleAreaMeasurement();
        irregularAreaMeasurement = new IrregularAreaMeasurement();
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

    public ObservableList<AreaShape> getAreaShapeTypes() {
        return areaShapeTypes;
    }

    public AreaShape getSelectedAreaShapeType() {
        return selectedAreaShapeType;
    }

    public void setSelectedAreaShapeType(AreaShape selectedAreaShapeType) {
        AreaShape oldValue = this.selectedAreaShapeType;
        this.selectedAreaShapeType = selectedAreaShapeType;
        support.firePropertyChange(AREA_SHAPE_TYPE_PROPERTY, oldValue, this.selectedAreaShapeType);
    }

    public double getLength() {
        return rectAngleAreaMeasurement.getLength();
    }

    public void setLength(double length) {

        if (rectAngleAreaMeasurement.getLength() == length) {
            return;
        }
        rectAngleAreaMeasurement.setLength(length);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getWidth() {
        return rectAngleAreaMeasurement.getWidth();
    }

    public void setWidth(double width) {

        if (rectAngleAreaMeasurement.getWidth() == width) {
            return;
        }
        rectAngleAreaMeasurement.setWidth(width);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getSide() {
        return squareAreaMeasurement.getSide();

    }

    public void setSide(double side) {
        if (squareAreaMeasurement.getSide() == side) {
            return;
        }
        squareAreaMeasurement.setSide(side);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getDiameter() {
        return circleAreaMeasurement.getDiameter();
    }

    public void setDiameter(double diameter) {

        if (circleAreaMeasurement.getDiameter() == diameter) {
            return;
        }
        circleAreaMeasurement.setDiameter(diameter);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getA() {
        return triangleAreaMeasurement.getA();
    }

    public void setA(double a) {

        if (triangleAreaMeasurement.getA() == a) {
            return;
        }

        triangleAreaMeasurement.setA(a);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getB() {
        return triangleAreaMeasurement.getB();
    }

    public void setB(double b) {
        if (triangleAreaMeasurement.getB() == b) {
            return;
        }

        triangleAreaMeasurement.setB(b);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getC() {
        return triangleAreaMeasurement.getC();
    }

    public void setC(double c) {
        if (triangleAreaMeasurement.getC() == c) {
            return;
        }
        triangleAreaMeasurement.setC(c);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public double getAreaValue() {
        return irregularAreaMeasurement.getAreaValue();
    }

    public void setAreaValue(double areaValue) {
        if (irregularAreaMeasurement.getAreaValue() == areaValue) {
            return;
        }
        irregularAreaMeasurement.setAreaValue(areaValue);
        support.firePropertyChange(AREA_SHAPE_VALUE_PROPERTY);
    }

    public AreaMeasurement getShape() {
        switch (this.selectedAreaShapeType) {
            case RECTANGLE:
                return rectAngleAreaMeasurement;
            case SQURE:
                return squareAreaMeasurement;
            case CIRCLE:
                return circleAreaMeasurement;
            case TRIANGLE:
                return triangleAreaMeasurement;
            case IRREGULAR:
                return irregularAreaMeasurement;
            default:
                return null;
        }
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/area/AreaFXML.fxml";
    }
}
