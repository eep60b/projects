package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.InformationDataModel;

/**
 *
 * @author zc
 */
public class ImageDataModel implements InformationDataModel {
  
    
    private String ImageFileLink;
    private String information;

    public String getImageFileLink() {
        return ImageFileLink;
    }

    public void setImageFileLink(String ImageFileLink) {
        this.ImageFileLink = ImageFileLink;
    }    

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
