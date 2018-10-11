package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import com.etlsolutions.javafx.presentation.Validatable;

/**
 *
 * @author zc
 */
public class AddImageDataModel implements InformationDataModel, FXMLActionDataModel, Savable, Validatable {

    public static final String IMAGE_FILE_LINK_PROPERTY = "com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel.IMAGE_FILE_LINK_PROPERTY";

    private String imageFileLink;
    private String information;
    private boolean valid;
    private String errorMessage;
    
    private final DataUnitFXMLDataModel parentModel;

    public AddImageDataModel(DataUnitFXMLDataModel parentModel) {
        imageFileLink = "";
        information = "";
        valid = true;
        this.parentModel = parentModel;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getImageFileLink() {
        return imageFileLink;
    }

    public void setImageFileLink(String imageFileLink) {
        String oldValue = this.imageFileLink;
        this.imageFileLink = imageFileLink;
        valid = imageFileLink != null && new File(imageFileLink).isFile();
        errorMessage = valid ? "" : "The image cannot be loaded.";
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

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/imagelink/AddImageLinkDialogFXML.fxml";
    }    

    @Override
    public void save() {
        parentModel.getImageLinks().add(new ImageLink(imageFileLink, information));
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
