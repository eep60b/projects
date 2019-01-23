package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class NewProjectDialigFXMLController extends AbstractComponentStageFXMLController<NewProjectDataModel> {

    @FXML
    private TextField nameTextField;
    
    @FXML
    private Label parentLocationLabel;

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
        nameTextField.setText(model.getNameValueWrapper().getValue());
        nameTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getNameValueWrapper()));
        model.getNameValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));
        
        parentLocationLabel.setText(model.getPathValueWrapper().getValue());
        parentLocationLabel.textProperty().addListener(new ValueChangeAdapter<>(model.getPathValueWrapper()));
        model.getPathValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));        
        
        browseButton.setOnAction(new NewProjectDialogBrowseButtonEventHandler(parentLocationLabel));        
        errorMessageLabel.setDisable(model.isInvalid());
        errorMessageLabel.setText(model.getErrorMessage());
        
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        okButton.setDisable(model.isInvalid());
        cancelButton.setOnAction(new CancelEventHandler(stage, model));
    }
}
