package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import static com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyAliasDataModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.etlsolutions.javafx.presentation.AbstractComponentStageFXMLController;

/**
 * AddVarietyAliasFXMLController is an FXML Controller class which control the save variety alias dialog.
 *
 * @author zc
 */
public class AddVarietyAliasFXMLController extends AbstractComponentStageFXMLController<AbstractVarietyDataModel> {
     
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

        AddVarietyAliasDataModel model = new AddVarietyAliasDataModel(this.model);
        titleTextField.setText(model.getTitle());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isInvalid());
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));
        
    //    model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
        
    }
}
