package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 * Container set, border area, raised-bed, normal-plant-bed
 *
 * @author zc
 */
public abstract class SubArea extends DataUnit {

    @JsonIgnore
    public static final String MEASUREMENT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.MEASUREMENT_PROPERTY";
    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.SubArea.SHAPE_PROPERTY";

    protected ObservableList<Location> allLocations;
    protected SubAreaMeasurement measurement;
    protected SubAreaShape shape;

    public SubArea() {

    }

    public SubArea(SubAreaMeasurement measurement, SubAreaShape shape, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        allLocations = new ObservableListWrapperA<>();
        this.measurement = measurement;
        this.shape = shape;
    }

    public SubArea(SubAreaMeasurement measurement, SubAreaShape shape, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        allLocations = new ObservableListWrapperA<>();
        this.measurement = measurement;
        this.shape = shape;
    }

    public abstract void updateAllLocations();

    public abstract SubAreaType getType();

    public ObservableList<Location> getAllLocations() {
        return allLocations;
    }

    public SubAreaMeasurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(SubAreaMeasurement measurement) {
        this.measurement = measurement;
        support.fireChange(MEASUREMENT_PROPERTY);
    }

    public SubAreaShape getShape() {
        return shape;
    }

    public void setShape(SubAreaShape shape) {
        SubAreaShape oldValue = this.shape;
        this.shape = shape;
        support.fireChange(SHAPE_PROPERTY, oldValue, this.shape);
    }
}
