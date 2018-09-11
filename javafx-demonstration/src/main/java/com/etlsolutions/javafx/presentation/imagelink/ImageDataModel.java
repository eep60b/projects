package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.InformationDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

/**
 *
 * @author zc
 */
public class ImageDataModel implements InformationDataModel {
  
    
   public static final String IMAGE_FILE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.IMAGE_FILE_LINK_PROPERTY";

    private String imageFileLink = "";
    private String information = "";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getImageFileLink() {
        return imageFileLink;
    }

    public void setImageFileLink(String ImageFileLink) {
        String oldValue = this.imageFileLink;
        this.imageFileLink = ImageFileLink;
        support.firePropertyChange(IMAGE_FILE_LINK_PROPERTY, oldValue, this.imageFileLink);
    }

    @Override
    public String getInformation() {
        return information;
    }

    @Override
    public void setInformation(String information) {
        this.information = information;
    }

    public boolean hasImage() {
        return imageFileLink != null && new File(imageFileLink).isFile();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }
}
