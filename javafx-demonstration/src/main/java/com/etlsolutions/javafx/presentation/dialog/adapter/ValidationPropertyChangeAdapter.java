package com.etlsolutions.javafx.presentation.dialog.adapter;

import com.etlsolutions.javafx.presentation.Validatable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
public class ValidationPropertyChangeAdapter implements PropertyChangeListener {

    private final Validatable model;
    private final Label errorMessageLabel;
    private final Button[] buttons;

    public ValidationPropertyChangeAdapter(Validatable model, Label errorMessageLabel, Button... buttons) {
        
        this.model = model;
        this.errorMessageLabel = errorMessageLabel;
        this.buttons = buttons;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        errorMessageLabel.setText(model.getErrorMessage());
        for(Button button : buttons) {
            button.setDisable(model.isInvalid());
        }
    }
}
