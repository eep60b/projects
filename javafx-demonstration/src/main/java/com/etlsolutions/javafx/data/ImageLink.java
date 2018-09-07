package com.etlsolutions.javafx.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The ImageLink class represents the path to a image on and its information.
 *
 * @author zc
 */
public class ImageLink {

    @JsonIgnore    
    public static final String IMAGE_LINK_LINK_PROPERTY = "com.etlsolutions.javafx.data.IMAGE_LINK_LINK_PROPERTY";
    
    private String link;
    private String information;

    @JsonIgnore
    private final DataUnitChangeSupport support = new DataUnitChangeSupport();

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        String oldValue = this.link;
        this.link = link;
        support.fireChange(IMAGE_LINK_LINK_PROPERTY, oldValue, this.link);
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void addListener(String property, DataUnitChangeListener listener) {
        support.addListener(property, listener);
    }
}
