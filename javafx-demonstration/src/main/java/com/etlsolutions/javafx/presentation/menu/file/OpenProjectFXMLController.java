package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class OpenProjectFXMLController extends AbstractComponentStageFXMLController<OpenProjectDataModel> {

    
    @FXML
    private Label locationLabel;

    @FXML
    private Button browseButton;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {        
        
        locationLabel.setText(model.getPathValueWrapper().getValue());
        locationLabel.textProperty().addListener(new ValueChangeAdapter<>(model.getPathValueWrapper()));
        model.getPathValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));        
        
        browseButton.setOnAction(new NewProjectDialogBrowseButtonEventHandler(locationLabel));        
        errorMessageLabel.setDisable(model.isInvalid());
        errorMessageLabel.setText(model.getErrorMessage());
        
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        okButton.setDisable(model.isInvalid());
        cancelButton.setOnAction(new CancelEventHandler(stage, model));
    }
}
