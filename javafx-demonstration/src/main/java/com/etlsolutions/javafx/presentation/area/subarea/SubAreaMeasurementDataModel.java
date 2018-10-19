package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.presentation.area.CircleDataModel;
import com.etlsolutions.javafx.presentation.area.SquareDataModel;
import com.etlsolutions.javafx.presentation.area.TriangleDataModel;
import com.etlsolutions.javafx.presentation.area.AreaValueDataModel;
import com.etlsolutions.javafx.presentation.area.LengthWidthDataModel;
import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class SubAreaMeasurementDataModel implements LengthWidthDataModel, AreaValueDataModel, TriangleDataModel, SquareDataModel, CircleDataModel {

    private final SubAreaMeasurement measurement;

    public SubAreaMeasurementDataModel(SubAreaMeasurement measurement) {
        this.measurement = measurement;
    }

    public SubAreaMeasurement getMeasurement() {
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

    public String getHeight() {
        return String.valueOf(measurement.getHeight());
    }

    public void setHeight(String height) {
        measurement.setHeight(Double.parseDouble(height));
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

    public String getVolume() {
        return String.valueOf(measurement.getVolume());
    }

    public void setVolume(String volume) {
        measurement.setVolume(Double.parseDouble(volume));
    }

    public String getDepth() {
        return String.valueOf(measurement.getDepth());
    }

    public void setDepth(String depth) {
        measurement.setDepth(Double.parseDouble(depth));
    }

    @Override
    public String getFxmlPath(Object shape) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
