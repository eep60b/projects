package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import static com.etlsolutions.javafx.presentation.menu.add.plantvariety.VarietyAliasDataModel.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.etlsolutions.javafx.presentation.FxmlControllable;

/**
 * AddVarietyAliasFXMLController is an FXML Controller class which control the add variety alias dialog.
 *
 * @author zc
 */
public class AddVarietyAliasFXMLController implements FxmlControllable<VarietyDialogDataModel> {

    private VarietyDialogDataModel parentModel;
    
    private Stage parentStage;
     
    @FXML
    private TextField titleTextField;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
   
    /**
     * Initialises the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        VarietyAliasDataModel model = new VarietyAliasDataModel(parentModel);
        titleTextField.setText(model.getTitle());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        okButton.setOnAction(new SaveExitEventHandler(model, parentStage));
        cancelButton.setOnAction(new CancelEventHandler(parentStage));
        
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
        
    }

    @Override
    public void setModel(VarietyDialogDataModel parentModel) {
        this.parentModel = parentModel;
    }

    @Override
    public void setStage(Stage parentStage) {
        this.parentStage = parentStage;
    }
}
