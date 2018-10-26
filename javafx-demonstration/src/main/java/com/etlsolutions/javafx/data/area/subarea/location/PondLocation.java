package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class PondLocation extends GroundLocation {

    public PondLocation() {
    }

    public PondLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }

    public PondLocation(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }

    @Override
    public LocationType getType() {
        return LocationType.POND_LOCATION;
    }
}
