package com.etlsolutions.javafx.presentation.dialog.plant.plantvariety;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.ValueChangeButtonPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * PlantVarietyFXMLController is an FXML Controller class which control the save plant item dialog.
 *
 * @author zc
 */
public class PlantVarietyFXMLController extends DataUnitFXMLController<PlantVariety, AbstractVarietyDataModel> {
    
  
    
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField latinNameTextField;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button addAliasButton;
    
    @FXML
    private Button removeAliasButton;
    
    @FXML
    private Button editAliasButton;
    
    @FXML 
    private ListView aliasListView;
    
    @FXML
    private Button addImageButton;
    
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
    private Button editImageButton;
    
    @FXML
    private Pane imageTilePane;
    
    @FXML
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;   


    @Override
    public void initializeComponents() {
     
        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        latinNameTextField.setText(model.getLatinNameValueWrapper().getValue());

        String alias = model.getSelectedAliasWalueWrapper().getValue();
        removeAliasButton.setDisable(alias == null);
        editAliasButton.setDisable(alias == null);
        
        aliasListView.setItems( model.getAliases());
        MultipleSelectionModel selectionModel = aliasListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        if(alias != null) {
            selectionModel.select(alias);
        }
        
        latinNameTextField.textProperty().addListener(new ValueChangeAdapter<>(model.getLatinNameValueWrapper()));
        addAliasButton.setOnAction(new FXMLActionEventHandler<>(new AddVarietyAliasDataModel(model)));
        editAliasButton.setOnAction(new FXMLActionEventHandler<>(new EditVarietyAliasDataModel(model)));
        removeAliasButton.setOnAction(new RemoveEventHandler(model, AbstractVarietyDataModel.REMOVE_ALIAS_ID));
        
        aliasListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedAliasWalueWrapper()));
      
        model.getSelectedAliasWalueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValueChangeButtonPropertyChangeAdapter<>(editAliasButton, removeAliasButton));
    }    
}
