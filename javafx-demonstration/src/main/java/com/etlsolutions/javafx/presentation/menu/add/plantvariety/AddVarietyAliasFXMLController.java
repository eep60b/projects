/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.ChildController;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.TitleDataModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddVarietyAliasFXMLController implements ChildController<VarietyDialogDataModel> {

    private VarietyDialogDataModel parentModel;
   
    @FXML
    private TextField titleTextField;
    
    @FXML
    private Label errorMessageLabel;
    
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

        VarietyAliasDataModel model = new VarietyAliasDataModel(parentModel);
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        
        
    }

    @Override
    public void setParent(VarietyDialogDataModel parentModel) {
        this.parentModel = parentModel;
    }
}
