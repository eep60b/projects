package com.etlsolutions.javafx.presentation.plant.plantvariety;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;

/**
 * VarietyAliasFXMLController is an FXML Controller class which control the save variety alias dialog.
 *
 * @author zc
 */
public class VarietyAliasFXMLController extends AbstractComponentStageFXMLController<AbstractVarietyAliasDataModel> {
     
    @FXML
    private TextField titleTextField;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;
   
    @Override
    public void initializeComponents() {
        
        titleTextField.setText(model.getTitleValueWrapper().getValue());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isInvalid());
        
        titleTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getTitleValueWrapper()));
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
        
        model.getTitleValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValidationPropertyChangeAdapter(model, errorMessageLabel, okButton));
        
    }
}
