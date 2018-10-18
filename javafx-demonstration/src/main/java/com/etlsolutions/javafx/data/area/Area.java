package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

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

    protected ObservableList<SubArea> allSubAreas;
    private double longitude;
    private double latitude;
    private AreaMeasurement measurement;
    
    public Area() {
    }

    protected Area(String title, String information) {
        super(title, information);
        this.allSubAreas = new ObservableListWrapperA<>();
    }

    protected Area(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, double longitude, double latitude, AreaMeasurement shape) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.allSubAreas = new ObservableListWrapperA<>();
        this.longitude = longitude;
        this.latitude = latitude;
        this.measurement = shape;
    }
   
    public abstract AreaType getType();
    
    public abstract void updateAllSubAreas();
    
    public abstract ObservableList<SubAreaType> getSubAreaTypes();

    public abstract ObservableList<SubArea> getSubAreas(SubAreaType type);  

    public ObservableList<SubArea> getAllSubAreas() {
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
}
