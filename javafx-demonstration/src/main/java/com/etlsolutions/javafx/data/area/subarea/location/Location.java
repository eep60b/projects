package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zc
 */
public abstract class Location extends DataUnit {

    @JsonIgnore
    public static final String PLANT_ID_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.PLANT_ID_PROPERTY";
    @JsonIgnore
    public static final String PARENT_ID_PROPERTY = "com.etlsolutions.javafx.data.area.subarea.location.Location.PARENT_ID_PROPERTY";
        
    private int plantId;
    private int parentId;
    
    public Location() {
    }

    public Location(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public Location(int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public abstract LocationType getType();

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        
        int oldValue = this.plantId;
        this.plantId = plantId;
        support.fireChange(PLANT_ID_PROPERTY, oldValue, this.plantId);
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        int oldValue = this.parentId;
        this.parentId = parentId;
        support.fireChange(PARENT_ID_PROPERTY, oldValue, this.parentId);
    }
}
