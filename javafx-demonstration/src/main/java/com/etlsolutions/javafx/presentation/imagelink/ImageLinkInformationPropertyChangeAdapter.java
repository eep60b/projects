package com.etlsolutions.javafx.presentation.imagelink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 */
class ImageLinkInformationPropertyChangeAdapter implements PropertyChangeListener {

    private final Button saveButton;
    private final Button saveExitButton;

    public ImageLinkInformationPropertyChangeAdapter(Button saveButton, Button saveExitButton) {
        this.saveButton = saveButton;
        this.saveExitButton = saveExitButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        boolean disabled = ((EditImageInformationDataModel) evt.getSource()).isNotChanged();
        saveButton.setDisable(disabled);
        saveExitButton.setDisable(disabled);
    }
    
}
