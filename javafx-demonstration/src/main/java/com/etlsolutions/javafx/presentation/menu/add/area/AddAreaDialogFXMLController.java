package com.etlsolutions.javafx.presentation.menu.add.area;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddAreaDialogFXMLController implements Initializable {

    
    @FXML
    private TextField titleTextField;
    
    @FXML
    private ComboBox typeComboBox;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button addImageButton;
    
    @FXML
    private Button editImageButton;
    
    @FXML
    private Button removeImageButton;
        
    @FXML
    private Tab contentsTab;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
