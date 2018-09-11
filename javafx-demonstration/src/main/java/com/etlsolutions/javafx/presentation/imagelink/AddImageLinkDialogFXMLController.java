package com.etlsolutions.javafx.presentation.imagelink;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddImageLinkDialogFXMLController implements Initializable {

    @FXML
    private Button addImageButton;
    
    @FXML
    private HBox imageHBox;
    
    @FXML
    private Label addImageButoonLabel;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;
    private Stage stage;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ImageDataModel model = new ImageDataModel();
        addImageButton.setOnAction(new AddImageEventHandler(model, stage));
    }    

    public void setOwnerWindow(Stage stage) {
        this.stage = stage;
    }
    
}
