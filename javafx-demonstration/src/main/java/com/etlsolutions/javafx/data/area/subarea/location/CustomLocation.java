package com.etlsolutions.javafx.data.area.subarea.location;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;

/**
 *
 * @author zc
 */
public class CustomLocation extends Location {

    public CustomLocation() {
    }

    public CustomLocation(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }

    public CustomLocation(int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
    }
        @Override
    public LocationType getType() {
        return LocationType.CUSTOMER_LOCATION;
    }
}
