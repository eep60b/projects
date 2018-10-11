package com.etlsolutions.javafx.presentation.menu.add.growingissue;

import com.etlsolutions.javafx.data.area.AreaShapeType;
import com.etlsolutions.javafx.data.area.AreaType;
import com.etlsolutions.javafx.presentation.AbstractFXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author Zhipeng
 */
public class AddGrowingIssueFXMLController extends AbstractFXMLController<AddGrowingIssueDataModel>{

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<AreaType> typeComboBox;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<AreaShapeType> shapeTypeComboBox;

    @FXML
    private HBox areaShapeContentHbox;

    @FXML
    private TextField longitudeTextField;

    @FXML
    private TextField latitudeTextField;

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
    private Tab contentsTab;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;    
    
    @Override
    public void initializeComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
