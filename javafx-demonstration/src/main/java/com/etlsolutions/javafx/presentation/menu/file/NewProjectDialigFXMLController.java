package com.etlsolutions.javafx.presentation.menu.file;

import com.etlsolutions.javafx.AbstractFXMLController;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class NewProjectDialigFXMLController extends AbstractFXMLController {

    @FXML
    private TextField nameTextField;
    
    @FXML
    private TextField parentLocationTextField;

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

        NewProjectDialogDataModel model = new NewProjectDialogDataModel();
        
        nameTextField.setText(model.getNameValueWrapper().getValue());
        nameTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getNameValueWrapper()));
        model.getNameValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));
        
        parentLocationTextField.setText(model.getPathValueWrapper().getValue());
        parentLocationTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getPathValueWrapper()));
        model.getPathValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));        
        
        browseButton.setOnAction(new NewProjectDialogBrowseButtonEventHandler(model));        
        errorMessageLabel.setDisable(model.isInvalid());
        errorMessageLabel.setText(model.getErrorMessage());
        
        okButton.setOnAction(new NewProjectDialogOkButtonEventHandler(model));
        okButton.setDisable(model.isInvalid());
        cancelButton.setOnAction(new NewProjectDialogCancelButtonEventHandler());
    }
}
