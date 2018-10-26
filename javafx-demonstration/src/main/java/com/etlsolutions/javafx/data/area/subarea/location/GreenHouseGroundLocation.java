package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class GreenHouseGroundLocation extends GroundLocation {

    public GreenHouseGroundLocation() {
    }

    public GreenHouseGroundLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }

    public GreenHouseGroundLocation(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }
    
        @Override
    public LocationType getType() {
        return LocationType.GREEN_HOUSE_GROUND_LOCATION;
    }
}
