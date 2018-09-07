package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDialogDataModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantVarietyDialogFXMLController implements Initializable {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField latinTextField;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button addAliasButton;
    
    @FXML
    private Button removeAliasButton;
    
    @FXML 
    private ListView aliasListView;
    
    @FXML
    private Button addImageButton;
    
    @FXML
    private Button removeImageButton;
    
    @FXML
    private Button moveToBeginButton;
    
    @FXML
    private Button moveToLeftButton;
    
    @FXML
    private Button moveToRightButton;
    
    @FXML
    private Button moveToEndButton;
    
    @FXML
    private HBox imagesHbox;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;   
    
    private AddPlantTypeDialogDataModel parentModel;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setParentModel(AddPlantTypeDialogDataModel parentModel) {
        this.parentModel = parentModel;
    }
    
}
