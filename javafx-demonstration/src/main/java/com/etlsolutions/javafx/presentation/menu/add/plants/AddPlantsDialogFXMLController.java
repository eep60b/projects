package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.event.Event;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import static com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.*;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeEventHandler;
import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantsDialogFXMLController implements Initializable {

    @FXML
    private TextField titleTextField;

    @FXML    
    private ComboBox<PlantGroup> plantGroupCombox;    
    
    @FXML    
    private ComboBox<PlantType> plantTypeCombox;
    
    @FXML
    private Button addPlantTypeButton;
        
    @FXML
    private ComboBox<PlantVariety> plantVarietyCombobox;
        
    @FXML
    private Button addPlantVarietyButton;
    
    @FXML
    private RadioButton singlePlantRadioButton;
    
    @FXML
    private RadioButton multiplePlantRadioButton;    
    
    @FXML
    private RadioButton estimatedPlantRadioButton;  
    
    @FXML
    private RadioButton notCountingRadioButton;
    
    @FXML
    private Spinner<Integer> plantNumberSpinner;
    
    @FXML
    private TextArea informationTextArea;
    
    @FXML
    private Button addImageButton;
    
    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToLeftImageButton;    
    
    @FXML
    private Button moveToRightImageButton;     
    
    @FXML
    private DatePicker datePlantedDatePicker;
        
    @FXML
    private ComboBox<PlantVariety> growingMediumCombobox;

    @FXML
    private Button addGrowingMediumButton;   
    
    @FXML
    private TextField locationTitleTextField;
    
    @FXML
    private Button editLocationButton;  
    
    @FXML
    private TextArea locationInformationTextArea;
    
    @FXML
    private CheckBox isAliveCheckBox;     
   
    @FXML
    private DatePicker terminationDatePicker;
    
    @FXML
    private TextArea terminationTextArea;
    
    @FXML
    private ListView<Event> eventListView;
    
    @FXML
    private Button addEventButton;
    
    @FXML
    private Button editEventButton;  
    
    @FXML
    private Button removeEventButton;      
    
    @FXML
    private ListView<Task> taskListView;
    
    @FXML
    private Button addTaskButton;
    
    @FXML
    private Button editTaskButton;  
    
    @FXML
    private Button removeTaskButton;      
    
    @FXML
    private ListView<GrowingIssue> issueListView;
    
    @FXML
    private Button addIssueButton;
    
    @FXML
    private Button editIssueButton;  
    
    @FXML
    private Button removeIssueButton;      
    
    @FXML
    private ListView<GrowingObservation> observationListView;
    
    @FXML
    private Button addObservationButton;
    
    @FXML
    private Button editObservationButton;  
    
    @FXML
    private Button removeObservationButton;     
    
    private Label errorMessageLabel;
        
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
        
        AddPlantsDataModel model = new AddPlantsDataModel();
        
        titleTextField.setText(model.getTitle());
        plantGroupCombox.setItems(model.getPlantGroups());
        plantGroupCombox.getSelectionModel().select(model.getSelectedPlantGroup());
        plantTypeCombox.setItems(model.getPlantTypes());
        plantTypeCombox.getSelectionModel().select(model.getSelectedPlantType());
        plantVarietyCombobox.setItems(model.getPlantVarieties());
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        plantGroupCombox.selectionModelProperty().addListener(new SelectPlantGroupChangeAdapter(model));
        plantTypeCombox.selectionModelProperty().addListener(new PlantTypeChangeAdapter(model));
        addPlantTypeButton.setOnAction(new AddPlantTypeEventHandler());
        
        model.addPropertyChangeListener(SELECTED_PLANT_GROUP_PROPERTY, new PlantGroupSelectionPropertyChangeAdapter(plantTypeCombox));
    }    

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
