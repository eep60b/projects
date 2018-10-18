package com.etlsolutions.javafx.presentation.area.subarea;

import com.etlsolutions.javafx.data.area.subarea.SubAreaMeasurement;

/**
 *
 * @author zc
 */
public class SubAreaMeasurementDataModel {

    private final SubAreaMeasurement measurement;

    public SubAreaMeasurementDataModel(SubAreaMeasurement measurement) {
        this.measurement = measurement;
    }

    public SubAreaMeasurement getMeasurement() {
        return measurement;
    }

    public double getAreaValue() {
        return measurement.getAreaValue();
    }

    public void setAreaValue(double areaValue) {
        measurement.setAreaValue(areaValue);
    }

    public double getHeight() {
        return measurement.getHeight();
    }

    public void setHeight(double height) {
        measurement.setHeight(height);
    }

    public double getLength() {
        return measurement.getLength();
    }

    public void setLength(double length) {
        measurement.setLength(length);
    }

    public double getWidth() {
        return measurement.getWidth();
    }

    public void setWidth(double width) {
        measurement.setWidth(width);
    }

    public double getSide() {
        return measurement.getSide();
    }

    public void setSide(double side) {
        measurement.setSide(side);
    }

    public double getDiameter() {
        return measurement.getDiameter();
    }

    public void setDiameter(double diameter) {
        measurement.setDiameter(diameter);
    }

    public double getA() {
        return measurement.getA();
    }

    public void setA(double a) {
        measurement.setA(a);
    }

    public double getB() {
        return measurement.getB();
    }

    public void setB(double b) {
        measurement.setB(b);
    }

    public double getC() {
        return measurement.getC();
    }

    public void setC(double c) {
        measurement.setC(c);
    }

    public double getVolume() {
        return measurement.getVolume();
    }

    public void setVolume(double volume) {
        measurement.setVolume(volume);
    }

    public double getDepth() {
        return measurement.getDepth();
    }

    public void setDepth(double depth) {
        measurement.setDepth(depth);
    }
    
    
}
