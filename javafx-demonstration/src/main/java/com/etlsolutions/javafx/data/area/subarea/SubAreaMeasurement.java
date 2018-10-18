package com.etlsolutions.javafx.data.area.subarea;

/**
 *
 * @author zc
 */
public class SubAreaMeasurement {

    private double areaValue;
    private double height;
    private double length;
    private double width;
    private double side;
    private double diameter;
    private double a;
    private double b;
    private double c;
    private double volume;
    private double depth;

    public SubAreaMeasurement() {
    }

    public SubAreaMeasurement(SubAreaMeasurement measurement) {
        areaValue = measurement.getAreaValue();
        height = measurement.getHeight();
        length= measurement.getLength();
        width = measurement.getWidth();
        side = measurement.getSide();
        diameter = measurement.getDiameter();
        a = measurement.getA();
        b = measurement.getB();
        c = measurement.getC();
        volume = measurement.getVolume();
        depth = measurement.getDepth();
    }

    public double getAreaValue() {
        return areaValue;
    }

    public void setAreaValue(double areaValue) {
        this.areaValue = areaValue;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }         
}
