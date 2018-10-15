package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddLocationFXMLController  extends DataUnitFXMLController<AddLocationDataModel> {
    
    @FXML
    private TextField titleTextField;
    
    @FXML
    private TextArea informationTextArea;

    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToBeginImageButton;

    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;

    @FXML
    private Button moveToEndImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton; 
    
    @FXML
    private ComboBox<Area> areaComboBox;
    
    @FXML
    private Button addAreaButton;
    
    @FXML
    private Button removeAreaButton;
    
    @FXML
    private Button editAreaButton;  
    
    @FXML
    private ComboBox<Area> subareaComboBox;
    
    @FXML
    private Button addSubareaButton;
    
    @FXML
    private Button removeSubareaButton;
    
    @FXML
    private Button editSubareaButton;  

    @FXML
    private Tab detailsTab;
    
    @Override
    public void initializeComponents() {
        
        try {
            initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);
            Node groundLocationNode = (Node) FXMLLoader.load(getClass().getResource(""));
        } catch (IOException ex) {
            Logger.getLogger(getClass()).error(ex);
   
        }
    }
    
}
