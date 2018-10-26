package com.etlsolutions.javafx.presentation.imagelink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
class ImageLinkInformationPropertyChangeAdapter implements PropertyChangeListener {

    private final Label errorMesssageLabel;    
    private final Button saveButton;
    private final Button saveExitButton;


    public ImageLinkInformationPropertyChangeAdapter(Label errorMesssageLabel, Button saveButton, Button saveExitButton) {
        this.errorMesssageLabel = errorMesssageLabel;
        this.saveButton = saveButton;
        this.saveExitButton = saveExitButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
  
        EditImageInformationDataModel model = ((EditImageInformationDataModel) evt.getSource());
        boolean valid = model.isInvalid();
        errorMesssageLabel.setText(model.getErrorMessage());
        errorMesssageLabel.setDisable(valid);
        saveButton.setDisable(!valid);
        saveExitButton.setDisable(!valid);
    }
    
}
