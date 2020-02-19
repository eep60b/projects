package com.etlsolutions.javafx.data.area;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.basicshape.GwisePoint;
import com.etlsolutions.javafx.data.area.measurement.Measurement;
import com.etlsolutions.javafx.data.area.measurement.MeasurementFactory;
import com.etlsolutions.javafx.data.area.measurement.MeasurementValueWrapper;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.SubAreaType;
import com.etlsolutions.gwise.data.basicshape.GwiseShape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * The Area class is a super class for all area.
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
public abstract class Area extends DataUnit implements Movable {

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
    private double centerX;
    private double centerY;
    private double ocuppiedWidth;
    private double occuppiedHeight;
    private Measurement measurement;
    private GwiseShapeType shapeType;
    private ObservableListWrapperA<SubArea> subAreas;

    private ObservableListWrapperA<GwisePoint> points;
    
    private GwiseShape shape;
    
    public Area() {
    }

    public Area(AreaValueWrapper areaValueWrapper, MeasurementValueWrapper measurementValueWrapper, ObservableListWrapperA<SubArea> subAreas) {
        super(areaValueWrapper);
        longitude = areaValueWrapper.getLongitude();
        latitude = areaValueWrapper.getLatitude();
        measurement = MeasurementFactory.getInstance().getAreaMeasurement(measurementValueWrapper);
        this.subAreas = new ObservableListWrapperA<>(subAreas);
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

    @Override
    public double getCenterX() {
        return centerX;
    }

    @Override
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    @Override
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    @Override
    public double getOcuppiedWidth() {
        return ocuppiedWidth;
    }

    @Override
    public void setOcuppiedWidth(double ocuppiedWidth) {
        this.ocuppiedWidth = ocuppiedWidth;
    }

    @Override
    public double getOccuppiedHeight() {
        return occuppiedHeight;
    }

    @Override
    public void setOccuppiedHeight(double occuppiedHeight) {
        this.occuppiedHeight = occuppiedHeight;
    }
    
    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
        fireChange(MEASUREMENT_PROPERTY);
    }

    public GwiseShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(GwiseShapeType shapeType) {
        GwiseShapeType oldValue = this.shapeType;
        this.shapeType = shapeType;
        fireChange(SHAPE_PROPERTY, oldValue, this.shapeType);
    }

    public GwiseShape getShape() {
        return shape;
    }

    public void setShape(GwiseShape shape) {
        
        GwiseShape oldValue = this.shape;
        this.shape = shape;
        fireChange(SHAPE_PROPERTY, oldValue, this.shape);        
    }
    
    public ObservableListWrapperA<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(ObservableListWrapperA<SubArea> subAreas) {
        this.subAreas = subAreas;
    }    

    public ObservableListWrapperA<GwisePoint> getPoints() {
        return points;
    }

    public void setPoints(ObservableListWrapperA<GwisePoint> points) {
        this.points = points;
    }
    
    public Shape shape() {
        
        //TODO:
        return new Rectangle();
    }
    
    
    @Override
    public String displayMessage() {
        
        StringBuilder builder = new StringBuilder(getTitle());
        builder.append("\n");
        builder.append(getType().getTitle()).append("   ");
        builder.append("longitute: ").append(getLongitude() == 0 ? "Not specified" : getLongitude());
        builder.append("latitute: ").append(getLatitude() == 0 ? "Not specified" : getLatitude());
        builder.append("\n");
        builder.append(getInformation());
        return new String(builder);
    }
}
