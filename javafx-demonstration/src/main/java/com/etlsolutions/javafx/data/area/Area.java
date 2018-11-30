package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementFactory;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
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

    private double longitude;
    private double latitude;
    private Measurement measurement;
    private AreaShape shape;

    public Area() {
    }

    public Area(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper) {
        super(valueWrapper);
        longitude = areaValueWrapper.getLongitude();
        latitude = areaValueWrapper.getLatitude();
        measurement = MeasurementFactory.getInstance().getAreaMeasurement(measurementValueWrapper);
    }

    public abstract AreaType getType();

    public abstract ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type);

    public abstract ObservableListWrapperA<SubArea> getAllSubAreas();
    
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

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
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

    public void remove(SubArea selectedSubArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
