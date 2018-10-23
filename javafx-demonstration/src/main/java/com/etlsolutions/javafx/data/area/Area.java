package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public abstract class Area extends DataUnit {

    @JsonIgnore
    public static final String LONGGITUDE_PROPERTY = "com.etlsolutions.javafx.data.area.Area.LONGGITUDE_PROPERTY";
    @JsonIgnore
    public static final String LATITUTE_PROPERTY = "com.etlsolutions.javafx.data.area.Area.LATITUTE_PROPERTY";
    @JsonIgnore
    public static final String MEASUREMENT_PROPERTY = "com.etlsolutions.javafx.data.area.Area.MEASUREMENT_PROPERTY";
    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.Area.SHAPE_PROPERTY";
    
    protected ObservableListWrapperA<SubArea> allSubAreas;
    private double longitude;
    private double latitude;
    private AreaMeasurement measurement;
    private AreaShape shape;

    public Area() {
    }

    protected Area(String title, String information) {
        super(title, information);
        this.allSubAreas = new ObservableListWrapperA<>();
    }

    protected Area(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement measurement, AreaShape shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.allSubAreas = new ObservableListWrapperA<>();
        this.longitude = longitude;
        this.latitude = latitude;
        this.measurement = measurement;
        this.shape = shape;
    }

    public abstract AreaType getType();

    public abstract void updateAllSubAreas();

    public abstract ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type);

    public ObservableListWrapperA<SubArea> getAllSubAreas() {
        return allSubAreas;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        double oldValue = this.longitude;
        this.longitude = longitude;
        fireChange(LONGGITUDE_PROPERTY, oldValue, this.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        double oldValue = this.latitude;
        this.latitude = latitude;
        fireChange(LATITUTE_PROPERTY, oldValue, this.latitude);
    }

    public AreaMeasurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(AreaMeasurement measurement) {
        this.measurement = measurement;
        fireChange(MEASUREMENT_PROPERTY);
    }

    public AreaShape getShape() {
        return shape;
    }

    public void setShape(AreaShape shape) {
        AreaShape oldValue = this.shape;
        this.shape = shape;
        fireChange(SHAPE_PROPERTY, oldValue, this.shape);
    }
}
