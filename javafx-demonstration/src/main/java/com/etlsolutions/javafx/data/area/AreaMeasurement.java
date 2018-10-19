package com.etlsolutions.javafx.data.area;

import static com.etlsolutions.javafx.system.SettingConstants.PI;

/**
 *
 * @author zc
 */
public class AreaMeasurement {
    
   private double areaValue;
    private double height;
    private double length;
    private double width;
    private double side;
    private double diameter;
    private double a;
    private double b;
    private double c;

    public AreaMeasurement() {
    }

    public AreaMeasurement(AreaMeasurement measurement) {
        areaValue = measurement.getAreaValue();
        height = measurement.getHeight();
        length= measurement.getLength();
        width = measurement.getWidth();
        side = measurement.getSide();
        diameter = measurement.getDiameter();
        a = measurement.getA();
        b = measurement.getB();
        c = measurement.getC();
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
        areaValue = this.width * this.length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        areaValue = this.width * this.length;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        areaValue = this.side * this.side;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        areaValue = (this.diameter / 2) * this.diameter / 2 * PI;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        calculateArea();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        calculateArea();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        calculateArea();
    }

    private void calculateArea() {

        double mean = (a + b + c) / 2;

        areaValue = Math.sqrt(mean * (mean - a) * (mean - b) * (mean - c));

    }      
}
