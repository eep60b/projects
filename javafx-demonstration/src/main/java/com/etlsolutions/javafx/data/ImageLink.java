package com.etlsolutions.javafx.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import com.etlsolutions.javafx.presentation.InformationDataModel;

/**
 * The ImageLink class represents the path to a image on and its information.
 *
 * @author zc
 */
public class ImageLink implements InformationDataModel {

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

    @Override
    public String getInformation() {
        return information;
    }

    @Override
    public void setInformation(String information) {
        this.information = information;
    }

    public void addListener(String property, DataUnitChangeListener listener) {
        support.addListener(property, listener);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.link);
        hash = 97 * hash + Objects.hashCode(this.information);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImageLink other = (ImageLink) obj;
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        return Objects.equals(this.information, other.information);
    }
}
