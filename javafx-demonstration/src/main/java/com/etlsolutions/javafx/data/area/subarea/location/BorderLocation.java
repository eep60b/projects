package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class BorderLocation extends GroundLocation {

    public BorderLocation() {
    }

    public BorderLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }

    public BorderLocation(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocationReferencePoint referencePoint, LocationDirection direction, double distance, double occupiedArea) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, referencePoint, direction, distance, occupiedArea);
    }

    @Override
    public LocationType getType() {
        return LocationType.BORDER_LOCATION;
    }
}
