package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantsGroup;
import static com.etlsolutions.javafx.presentation.menu.add.planttype.PlantTypeDialogDataModel.TITLE_PROPERTY;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddPlantVarietyEventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantTypeDialogFXMLController implements Initializable {

    @FXML
    private TextField titleTextField;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private ComboBox<PlantsGroup> groupComboBox;
    
    @FXML
    private Button addVarityButton;
    
    @FXML
    private Button removeVarityButton;
    
    @FXML
    private Button editVarityButton;
    
    @FXML 
    private ListView varityListView;
    
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
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PlantTypeDialogDataModel model = new PlantTypeDialogDataModel();
        titleTextField.setText(model.getTitle());
        informationTextArea.setText(model.getInformation());
        
        groupComboBox.getItems().addAll(model.getPlantGroups());
        groupComboBox.getSelectionModel().select(model.getSelectedPlantGroup());
        
        addVarityButton.setOnAction(new AddPlantVarietyEventHandler(model));
        
        errorMessageLabel.setVisible(!model.isValid());
        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());
        
        titleTextField.textProperty().addListener(new AddPlantTypeTitleChangeListener(model));
        informationTextArea.textProperty().addListener(new AddPlantTypeInformationChangeListener(model));
        groupComboBox.selectionModelProperty().addListener(new AddPlantTypePlantGroupChangeListener(model));
        model.addPropertyChangeListener(TITLE_PROPERTY, new AddPlantTypeTitlePropertyChangeListener(model, errorMessageLabel, okButton));
    }    
    
}
