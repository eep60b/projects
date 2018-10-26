package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Container extends Location {

    @JsonIgnore
    public static final String SHAPE_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.SHAPE_PROPERTY";
    @JsonIgnore
    public static final String HEIGHT_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.HEIGHT_PROPERTY";
    @JsonIgnore
    public static final String VOLUMN_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Container.VOLUMN_PROPERTY";
        
    private ContainerShape shape;
    private double height;
    private double volume;

    public Container() {
    }

    public Container(ContainerShape shape, double height, double volumn, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.shape = shape;
        this.height = height;
        this.volume = volumn;
    }

    public Container(ContainerShape shape, double height, double volumn, int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        this.shape = shape;
        this.height = height;
        this.volume = volumn;
    }

    public ContainerShape getShape() {
        return shape;
    }

    public void setShape(ContainerShape shape) {
        ContainerShape oldValue = this.shape;
        this.shape = shape;
        fireChange(SHAPE_PROPERTY, oldValue, this.shape);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        double oldValue = this.height;
        this.height = height;
        fireChange(HEIGHT_PROPERTY, oldValue, this.height);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        double oldValue = this.volume;
        this.volume = volume;
        fireChange(VOLUMN_PROPERTY, oldValue, this.volume);
    }

    @Override
    public LocationType getType() {
        return LocationType.CONTAINER;
    }
}
