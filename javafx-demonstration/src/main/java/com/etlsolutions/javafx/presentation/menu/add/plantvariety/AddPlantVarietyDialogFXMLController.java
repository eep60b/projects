package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.add.planttype.PlantTypeDialogDataModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
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
    private TextField latinNameTextField;
    
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
    private Label errorMessageLabel;
    
    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;   
    
    private PlantTypeDialogDataModel parentModel;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        VarietyDialogDataModel model = new VarietyDialogDataModel(parentModel);
        titleTextField.setText(model.getTitle());
        latinNameTextField.setText(model.getLatinName());
        informationTextArea.setText(model.getInformation());
        
        aliasListView.setItems( model.getAliases());
        String alias = model.getSelectedAlias();
        MultipleSelectionModel selectionModel = aliasListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        if(alias != null) {
            selectionModel.select(alias);
        }
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        latinNameTextField.textProperty().addListener(new LatinNameChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        aliasListView.selectionModelProperty().addListener(new AliasChangeAdapter(model));
        addAliasButton.setOnAction(new AddAliasEventHandler(model));
    }    

    public void setParentModel(PlantTypeDialogDataModel parentModel) {
        this.parentModel = parentModel;
    }
    
}
