package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.presentation.InformationDataModel;
import com.etlsolutions.javafx.presentation.Savable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 *
 * @author zc
 */
public class EditImageInformationDataModel implements InformationDataModel, Savable {

    public static final String INFORMATION_PROPERTY = "com.etlsolutions.javafx.data.ImageLink.EditImageInformationDataModel.INFORMATION_PROPERTY";
    
    private final ImageLink imageLink;
    private String information;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
            
    public EditImageInformationDataModel(ImageLink imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public void setInformation(String information) {
        String oldValue = this.information;
        this.information = information;
        support.firePropertyChange(INFORMATION_PROPERTY, oldValue, this.information);
    }

    @Override
    public String getInformation() {
        return information;
    }   
    
    public boolean isNotChanged() {
        return Objects.equals(information, imageLink.getInformation());
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void save() {
        String oldValue = imageLink.getInformation();
        imageLink.setInformation(information);
        support.firePropertyChange(INFORMATION_PROPERTY, oldValue, imageLink.getInformation());        
    }
}
