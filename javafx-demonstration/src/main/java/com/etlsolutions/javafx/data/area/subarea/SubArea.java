package com.etlsolutions.javafx.data.area.subarea;

import com.etlsolutions.javafx.data.DataUnit;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.ObservableList;

/**
 * Container set, border area, raised-bed, normal-plant-bed
 *
 * @author zc
 */
public abstract class SubArea extends DataUnit {

    protected  ObservableList<Location> allLocations;

    public SubArea() {
        
    }

    public SubArea(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        allLocations = new ObservableListWrapperA<>();
    }

    public SubArea(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        allLocations = new ObservableListWrapperA<>();
    }
    
    
    
    public abstract void updateAllLocations();

    public abstract SubAreaType getType();
    
    public abstract ObservableList<LocationType> getLocationTypes();

    public ObservableList<Location> getAllLocations() {
        return allLocations;
    }
}
