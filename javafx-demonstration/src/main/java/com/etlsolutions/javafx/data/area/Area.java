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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author zc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(name = "BalconyArea", value = BalconyArea.class),
    @JsonSubTypes.Type(name = "CustomArea", value = CustomArea.class),
    @JsonSubTypes.Type(name = "FarmArea", value = FarmArea.class),
    @JsonSubTypes.Type(name = "GardenArea", value = GardenArea.class),
    @JsonSubTypes.Type(name = "IndoorArea", value = IndoorArea.class),
    @JsonSubTypes.Type(name = "PatioArea", value = PatioArea.class)
})
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
    private ObservableListWrapperA<SubArea> subAreas;    

    public Area() {
    }

    public Area(DataUnitValueWrapper valueWrapper, AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper) {
        super(valueWrapper);
        longitude = areaValueWrapper.getLongitude();
        latitude = areaValueWrapper.getLatitude();
        measurement = MeasurementFactory.getInstance().getAreaMeasurement(measurementValueWrapper);
        subAreas = new ObservableListWrapperA<>();
    }

    @JsonIgnore
    public abstract AreaType getType();

    public abstract ObservableListWrapperA<SubArea> getSubAreas(SubAreaType type);

    @JsonIgnore
    public abstract ObservableListWrapperA<SubArea> getAllSubAreas();

    /**
     * Remove the specified SubArea object.
     *
     * @param selectedSubArea - The object to be removed.
     */
    public abstract void remove(SubArea selectedSubArea);

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
    
    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(ObservableListWrapperA<SubArea> subAreas) {
        this.subAreas = subAreas;
    }    
}
