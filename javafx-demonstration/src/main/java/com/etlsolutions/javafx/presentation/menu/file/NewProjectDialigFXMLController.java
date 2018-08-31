package com.etlsolutions.javafx.presentation.menu.file;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class NewProjectDialigFXMLController implements Initializable {

    @FXML
    private TextField nameTextField;
    
    @FXML
    private TextField parentLocationTextField;

    @FXML
    private Button browseButton;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        NewProjectDialogDataModel model = new NewProjectDialogDataModel();
        
        nameTextField.textProperty().addListener(new NewProjectDialogNameTextFieldChangeListener(model));
        parentLocationTextField.textProperty().addListener(new NewProjectDialogPathTextFieldChangeListener(model));
        browseButton.setOnAction(new NewProjectDialogBrowseButtonEventHandler(model));
        okButton.setOnAction(new NewProjectDialogOkButtonEventHandler(model));
        cancelButton.setOnAction(new NewProjectDialogCancelButtonEventHandler());
    }
}
