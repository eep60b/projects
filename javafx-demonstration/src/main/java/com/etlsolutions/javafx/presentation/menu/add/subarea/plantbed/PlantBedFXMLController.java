/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.subarea.plantbed;

import com.etlsolutions.javafx.data.area.AreaShapeType;
import com.etlsolutions.javafx.data.area.AreaType;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class PlantBedFXMLController implements Initializable {

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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
