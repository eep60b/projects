package com.etlsolutions.javafx.presentation.menu.add.area;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.javafx.data.area.AreaShape;
import com.etlsolutions.javafx.data.area.AreaShapeType;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.data.area.CircleAreaShape;
import com.etlsolutions.javafx.data.area.IrregularAreaShape;
import com.etlsolutions.javafx.data.area.RectAngleAreaShape;
import com.etlsolutions.javafx.data.area.SquareAreaShape;
import com.etlsolutions.javafx.data.area.TriangleAreaShape;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import com.etlsolutions.javafx.system.ProjectManager;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author Zhipeng
 */
public class AddAreaDialogDataModel extends DataUnitFXMLDataModel implements Validatable {

    public static final String LONGITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LONGITUDE_PROPERTY";
    public static final String LATITUDE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.LATITUDE_PROPERTY";
    public static final String AREA_SHAPE_TYPE_PROPERTY = "com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel.AREA_SHAPE_TYPE_PROPERTY";

    private final ObservableList<AreaType> areaTypes;
    private AreaType selectedAreaType;
    private double longitude;
    private double latitude;
    private final ObservableList<AreaShapeType> areaShapeTypes;
    private AreaShapeType selectedAreaShapeType;
    private final RectAngleAreaShape rectAngleAreaShape;
    private final SquareAreaShape squareAreaShape;
    private final CircleAreaShape circleAreaShape;
    private final TriangleAreaShape triangleAreaShape;
    private final IrregularAreaShape irregularAreaShape;

    public AddAreaDialogDataModel() {
        this.areaTypes = new ObservableListWrapperA<>(Arrays.asList(AreaType.values()));
        selectedAreaType = areaTypes.get(0);
        this.areaShapeTypes = new ObservableListWrapperA<>(Arrays.asList(AreaShapeType.values()));
        selectedAreaShapeType = areaShapeTypes.get(0);
        rectAngleAreaShape = new RectAngleAreaShape();
        squareAreaShape = new SquareAreaShape();
        circleAreaShape = new CircleAreaShape();
        triangleAreaShape = new TriangleAreaShape();
        irregularAreaShape = new IrregularAreaShape();
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

    public ObservableList<AreaShapeType> getAreaShapeTypes() {
        return areaShapeTypes;
    }

    public AreaShapeType getSelectedAreaShapeType() {
        return selectedAreaShapeType;
    }

    public void setSelectedAreaShapeType(AreaShapeType selectedAreaShapeType) {
        AreaShapeType oldValue = this.selectedAreaShapeType;
        this.selectedAreaShapeType = selectedAreaShapeType;
        support.firePropertyChange(AREA_SHAPE_TYPE_PROPERTY, oldValue, this.selectedAreaShapeType);
    }

    public double getLength() {
        return rectAngleAreaShape.getLength();
    }

    public void setLength(double length) {
        rectAngleAreaShape.setLength(length);
    }

    public double getWidth() {
        return rectAngleAreaShape.getWidth();
    }

    public void setWidth(double width) {
        rectAngleAreaShape.setWidth(width);
    }

    public double getSide() {
        return squareAreaShape.getSide();
    }

    public void setSide(double side) {
        squareAreaShape.setSide(side);
    }

    public double getDiameter() {
        return circleAreaShape.getDiameter();
    }

    public void setDiameter(double diameter) {
        circleAreaShape.setDiameter(diameter);
    }

    public double getA() {
        return triangleAreaShape.getA();
    }

    public void setA(double a) {
        triangleAreaShape.setA(a);
    }

    public double getB() {
        return triangleAreaShape.getB();
    }

    public void setB(double b) {
        triangleAreaShape.setB(b);
    }

    public double getC() {
        return triangleAreaShape.getC();
    }

    public void setC(double c) {
        triangleAreaShape.setC(c);
    }

    public double getArea() {
        return irregularAreaShape.getArea();
    }

    public void setArea(double area) {
        irregularAreaShape.setArea(area);
    }

    @Override
    protected void validate() {

        valid = title != null && !title.isEmpty();
        if (!valid) {
            errorMessage = "Enter the title";
        }
    }

    @Override
    public void save() {

        AreaShape selectedShape;
        switch (this.selectedAreaShapeType) {
            case RECTANGLE:
                selectedShape = rectAngleAreaShape;
                break;

            case SQURE:
                selectedShape = squareAreaShape;
                break;

            case CIRCLE:
                selectedShape = circleAreaShape;
                break;
            case TRIANGLE:
                selectedShape = triangleAreaShape;
                break;
            case IRREGULAR:
                selectedShape = irregularAreaShape;
                break;
            default:
                selectedShape = null;
        }
        Area a = AreaFactory.createArea(selectedAreaType, title, information, imageLinks, imageLinks.indexOf(getSelectedImageLink()), "", -300, -300, selectedShape);
        ProjectManager.getInstance().getProject().getAreaRoot().getAllAreas().add(a);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/menu/add/AddAreaDialogFXML.fxml";
    }
}
