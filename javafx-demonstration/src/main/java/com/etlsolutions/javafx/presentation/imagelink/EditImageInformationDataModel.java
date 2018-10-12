package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Validatable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import com.etlsolutions.javafx.presentation.Addable;

/**
 *
 * @author zc
 */
public class EditImageInformationDataModel implements InformationDataModel, FXMLActionDataModel, Addable, Validatable {

    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.data.ImageLink.EditImageInformationDataModel.INFORMATION_PROPERTY";
    
    private final ImageLink imageLink;
    private String information;
    private boolean valid;
    private String errorMessage;
            
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
            
    public EditImageInformationDataModel(ImageLink imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public void setInformation(String information) {
        String oldValue = this.information;
        this.information = information;
        valid = Objects.equals(information, imageLink.getInformation());
        errorMessage = valid ? "" : "The information has NOT been changed.";
        support.firePropertyChange(INFORMATION_PROPERTY, oldValue, this.information);
    }

    @Override
    public String getInformation() {
        return information;
    }   

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void add() {
        String oldValue = imageLink.getInformation();
        imageLink.setInformation(information);
        
        support.firePropertyChange(INFORMATION_PROPERTY, oldValue, imageLink.getInformation());        
    }

    @Override
    public String getFxmlPath() {
        return "/fxml/imagelink/EditImageInformationDialogFXML.fxml";
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
