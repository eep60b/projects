package com.etlsolutions.javafx.presentation.menu.add.planttype;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
class AddPlantTypeTitlePropertyChangeListener implements PropertyChangeListener {

    private final PlantTypeDialogDataModel model;
    private final Label errorMessageLabel;
    private final Button okButton;

    public AddPlantTypeTitlePropertyChangeListener(PlantTypeDialogDataModel model, Label errorMessageLabel, Button okButton) {
        this.model = model;
        this.errorMessageLabel = errorMessageLabel;
        this.okButton = okButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        errorMessageLabel.setVisible(!model.isValid());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());
    }
    
}
