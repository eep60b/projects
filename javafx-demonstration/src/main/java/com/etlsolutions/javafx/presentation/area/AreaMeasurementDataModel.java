package com.etlsolutions.javafx.presentation.area;

import com.etlsolutions.javafx.data.area.Measurement;
import com.etlsolutions.javafx.data.area.AreaShape;

/**
 *
 * @author zc
 */
public class AreaMeasurementDataModel implements LengthWidthDataModel, SquareDataModel, CircleDataModel, TriangleDataModel, AreaValueDataModel {

    private final Measurement measurement;

    public AreaMeasurementDataModel(Measurement measurement) {
        this.measurement = measurement;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    @Override
    public String getAreaValue() {
        return String.valueOf(measurement.getAreaValue());
    }

    @Override
    public void setAreaValue(String areaValue) {
        measurement.setAreaValue(Double.parseDouble(areaValue));
    }

    @Override
    public String getLength() {
        return String.valueOf(measurement.getLength());
    }

    @Override
    public void setLength(String length) {
        measurement.setLength(Double.parseDouble(length));
    }

    @Override
    public String getWidth() {
        return String.valueOf(measurement.getWidth());
    }

    @Override
    public void setWidth(String width) {
        measurement.setWidth(Double.parseDouble(width));
    }

    @Override
    public String getSide() {
        return String.valueOf(measurement.getSide());
    }

    @Override
    public void setSide(String side) {
        measurement.setSide(Double.parseDouble(side));
    }

    @Override
    public String getDiameter() {
        return String.valueOf(measurement.getDiameter());
    }

    @Override
    public void setDiameter(String diameter) {
        measurement.setDiameter(Double.parseDouble(diameter));
    }

    @Override
    public String getA() {
        return String.valueOf(measurement.getA());
    }

    @Override
    public void setA(String a) {
        measurement.setA(Double.parseDouble(a));
    }

    @Override
    public String getB() {
        return String.valueOf(measurement.getB());
    }

    @Override
    public void setB(String b) {
        measurement.setB(Double.parseDouble(b));
    }

    @Override
    public String getC() {
        return String.valueOf(measurement.getC());
    }

    @Override
    public void setC(String c) {
        measurement.setC(Double.parseDouble(c));
    }

    @Override
    public String getFxmlPath(Object object) {
        AreaShape shape = (AreaShape) object;
        switch (shape) {
            case RECTANGLE:
                return "/fxml/area/LengthWidthFXML.fxml";
            case SQURE:
                return "/fxml/area/SquareFXML.fxml";
            case CIRCLE:
                return "/fxml/area/CircleFXML.fxml";
            case TRIANGLE:
                return "/fxml/area/TriangleFXML.fxml";
            case IRREGULAR:
                return "/fxml/area/AreaValueFXML.fxml";
            default:
                throw new IllegalArgumentException("Invalid shape.");
        }
    }
}
