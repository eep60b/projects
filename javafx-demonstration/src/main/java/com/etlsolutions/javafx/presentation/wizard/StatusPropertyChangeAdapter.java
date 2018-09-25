package com.etlsolutions.javafx.presentation.wizard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author zc
 */
public class StatusPropertyChangeAdapter implements PropertyChangeListener {

    private final Button previousPageButton;
    private final Button nextPageButton;
    private final Button finishButton;
    private final Label errorMessageLabel;

    public StatusPropertyChangeAdapter(Button previousPageButton, Button nextPageButton, Button finishButton, Label errorMessageLabel) {
        this.previousPageButton = previousPageButton;
        this.nextPageButton = nextPageButton;
        this.finishButton = finishButton;
        this.errorMessageLabel = errorMessageLabel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        WizardDataModel model = (WizardDataModel) evt.getSource();
        previousPageButton.setDisable(model.notToPrevious());
        nextPageButton.setDisable(model.notToNext());
        finishButton.setDisable(model.canNotFinish());
        errorMessageLabel.setText(model.getErrorMessage());
    }
    
}
