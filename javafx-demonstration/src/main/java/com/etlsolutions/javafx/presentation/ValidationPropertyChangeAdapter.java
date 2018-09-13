package com.etlsolutions.javafx.presentation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
public class ValidationPropertyChangeAdapter implements PropertyChangeListener {

    private final Label errorMessageLabel;
    private final Button[] buttons;

    public ValidationPropertyChangeAdapter(Label errorMessageLabel, Button... buttons) {
        
        this.errorMessageLabel = errorMessageLabel;
        this.buttons = buttons;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        Validatable validatable = (Validatable) evt.getSource();
        errorMessageLabel.setText(validatable.getErrorMessage());
        for(Button button : buttons) {
            button.setDisable(!validatable.isValid());
        }
    }
}
