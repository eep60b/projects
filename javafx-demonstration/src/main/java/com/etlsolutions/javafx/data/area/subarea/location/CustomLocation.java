package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class CustomLocation extends Location {

    public CustomLocation() {
    }

    public CustomLocation(String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public CustomLocation(int id, String title, String information, ObservableList<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }
        @Override
    public LocationType getType() {
        return LocationType.CUSTOMER_LOCATION;
    }
}
