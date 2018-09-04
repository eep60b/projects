package com.etlsolutions.javafx.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The ImageLink class represents the path to a image on and its description.
 *
 * @author zc
 */
public class ImageLink {

    @JsonIgnore    
    public static final String IMAGE_LINK_LINK_PROPERTY = "com.etlsolutions.javafx.data.IMAGE_LINK_LINK_PROPERTY";
    private String link;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addListener(String property, DataUnitChangeListener listener) {
        support.addListener(property, listener);
    }
}
