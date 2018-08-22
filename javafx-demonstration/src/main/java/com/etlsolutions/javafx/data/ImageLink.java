package com.etlsolutions.javafx.data;

/**
 * The ImageLink class represents the path to a image on and its description.
 *
 * @author zc
 */
public class ImageLink extends DataUnit {

    public static final String IMAGE_LINK_LINK_PROPERTY = "com.etlsolutions.javafx.data.IMAGE_LINK_LINK_PROPERTY";
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        String oldValue = this.link;
        this.link = link;
        fireChange(IMAGE_LINK_LINK_PROPERTY, oldValue, this.link);
    }
}
