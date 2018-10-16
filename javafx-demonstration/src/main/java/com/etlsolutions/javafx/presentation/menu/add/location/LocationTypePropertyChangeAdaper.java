package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyAliasDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
public class LocationTypePropertyChangeAdaper implements PropertyChangeListener {

    private final Button okButton;
    private final Label errorMessageLabel;

    public LocationTypePropertyChangeAdaper(Button okButton, Label errorMessageLabel) {
        this.okButton = okButton;
        this.errorMessageLabel = errorMessageLabel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddVarietyAliasDataModel model = (AddVarietyAliasDataModel) evt.getSource();
        okButton.setDisable(!model.isValid());
        errorMessageLabel.setDisable(!model.isValid());
        errorMessageLabel.setText(model.getErrorMessage());
    }
    
}
