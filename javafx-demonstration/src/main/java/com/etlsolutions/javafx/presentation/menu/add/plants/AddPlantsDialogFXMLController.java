package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.event.Event;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.plant.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.imagelink.AddImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.RemoveImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumEventHandler;
import static com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.*;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddPlantVarietyEventHandler;
import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private QuantityTypeRadioButton singlePlantRadioButton;

    @FXML
    private QuantityTypeRadioButton multiplePlantRadioButton;

    @FXML
    private QuantityTypeRadioButton estimatedPlantRadioButton;

    @FXML
    private QuantityTypeRadioButton notCountingRadioButton;

    @FXML
    private Spinner<Integer> plantNumberSpinner;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private Button addImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button editImageButton;
    
    @FXML
    private Button moveToBeginImageButton;
    
    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;
    
    @FXML
    private Button moveToEndImageButton;
    
    @FXML
    private DateTimePicker plantedDatePicker;

    @FXML
    private ComboBox<GrowingMedium> growingMediumCombobox;

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
     *
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
        singlePlantRadioButton.setType(PlantsQuantity.Type.SINGLE);
        multiplePlantRadioButton.setType(PlantsQuantity.Type.MULTIPLE);
        estimatedPlantRadioButton.setType(PlantsQuantity.Type.ESTIMATION);
        notCountingRadioButton.setType(PlantsQuantity.Type.NO_COUNTING);

        switch (model.getQuantityType()) {
            case SINGLE:
                singlePlantRadioButton.setSelected(true);
                break;
            case MULTIPLE:
                multiplePlantRadioButton.setSelected(true);
                break;
            case ESTIMATION:
                estimatedPlantRadioButton.setSelected(true);
                break;
            case NO_COUNTING:
                notCountingRadioButton.setSelected(true);
                break;
            default:
                throw new IllegalStateException("Invalid type");
        }
        
        ((IntegerSpinnerValueFactory)plantNumberSpinner.getValueFactory()).valueProperty().setValue(model.getPlantNumber());
        PlantsQuantity.Type type = model.getQuantityType();
        plantNumberSpinner.setDisable(type == PlantsQuantity.Type.SINGLE || type == PlantsQuantity.Type.NO_COUNTING);
        ((IntegerSpinnerValueFactory)plantNumberSpinner.getValueFactory()).setMin(0);
        
        informationTextArea.setText(model.getInformation());
        
        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);
        List<ImageLink> imageLinks = model.getImageLinks();
        moveToBeginImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToLeftImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToEndImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        moveToRightImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        editImageButton.setDisable(selectedImageLink == null);   
        
        plantedDatePicker.setDateTimeValue(model.getPlantedDate());
        growingMediumCombobox.setItems(model.getGrowingMediums());
        growingMediumCombobox.getSelectionModel().select(model.getSelectedGrowingMedium());
        
        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        plantGroupCombox.selectionModelProperty().addListener(new SelectPlantGroupChangeAdapter(model));
        plantTypeCombox.selectionModelProperty().addListener(new PlantTypeChangeAdapter(model));
        addPlantTypeButton.setOnAction(new AddPlantTypeEventHandler());
        addPlantVarietyButton.setOnAction(new AddPlantVarietyEventHandler(new AddVarityToPlantsDialogDataModel(model)));
        addGrowingMediumButton.setOnAction(new AddGrowingMediumEventHandler(new AddGrowingMediumDataModel(model)));
        Location location = model.getLocation();
        locationTitleTextField.setText(location == null ? "Not Specified" : location.getTitle());
        locationTitleTextField.setDisable(true);
        locationInformationTextArea.setText(location == null ? "" : location.getInformation());
        locationInformationTextArea.setDisable(true);
        editLocationButton.setOnAction(new EditPlantLocationEventHandler(model));
        

        ToggleGroup toggleGroup = new ToggleGroup();
        singlePlantRadioButton.setToggleGroup(toggleGroup);
        multiplePlantRadioButton.setToggleGroup(toggleGroup);
        estimatedPlantRadioButton.setToggleGroup(toggleGroup);
        notCountingRadioButton.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new PlantNumberTypeChangeAdapter(model));
        plantNumberSpinner.valueProperty().addListener(new PlantNumberChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));
        
        addImageButton.setOnAction(new AddImageLinkEventHandler(model));
        removeImageButton.setOnAction(new RemoveImageLinkEventHandler(model));
        moveToBeginImageButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new EditImageInformationEventHandler(model.getSelectedImageLink()));
        plantedDatePicker.dateTimeValueProperty().addListener(new PlantedDateChangeAdapter(model));
        growingMediumCombobox.selectionModelProperty().addListener(new GrowingMediumChangeAdapter(model));

        model.addPropertyChangeListener(SELECTED_PLANT_GROUP_PROPERTY, new PlantGroupSelectionPropertyChangeAdapter(plantTypeCombox));
        model.addPropertyChangeListener(QUANTITY_TYPE_PROPERTY, new QuantityTypePropertyChangeAdapter(plantNumberSpinner));
        model.addPropertyChangeListener(SELECTED_GROWING_MEDIUM_RPOPERTY, new GrowingMediumSelectionPropertyChangeDapter(growingMediumCombobox));
        model.addPropertyChangeListener(LOCATION_PROPERTY, new LocationPropertyChangeAdapter(locationTitleTextField, locationInformationTextArea, editLocationButton));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
