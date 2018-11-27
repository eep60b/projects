package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.CurrentMaxDayCellFactory;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import static com.etlsolutions.javafx.data.plant.PlantsQuantity.Type.SINGLE;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantsFXMLController extends DataUnitFXMLController<Plants, AddPlantsDataModel> {

    @FXML
    private TextField titleTextField;
    
    @FXML
    private Pane imageTilePane;

    @FXML
    private ComboBox<PlantGroup> plantGroupCombox;

    @FXML
    private ComboBox<PlantSubGroup> plantTypeCombox;

    @FXML
    private Button addPlantTypeButton;

    @FXML
    private ComboBox<PlantVariety> plantVarietyCombobox;

    @FXML
    private Button addPlantVarietyButton;

    @FXML
    private HBox plantNumberTypeHbox;

    @FXML
    private HBox plantNumberHbox;

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
    HBox datePlantedHbox;

    @FXML
    private ComboBox<GrowingMedium> growingMediumCombobox;

    @FXML
    private Button addGrowingMediumButton;

    @FXML
    private Label locationTitleLabel;

    @FXML
    private Button editLocationButton;

    @FXML
    private TextArea locationInformationTextArea;

    @FXML
    private CheckBox isAliveCheckBox;

    @FXML
    private HBox terminationDateHbox;

    @FXML
    private Label terminationDatePickerLabel;

    @FXML
    private TextArea terminationTextArea;

    @FXML
    private ListView<Gvent> eventListView;

    @FXML
    private Label terminationReasonTextAreaLabel;

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

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @Override
    public void initializeComponents() {

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        plantGroupCombox.setItems(model.getPlantGroups());
        plantGroupCombox.getSelectionModel().select(model.getPlantGroupValueWrapper().getValue());
        plantGroupCombox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getPlantGroupValueWrapper()));
        model.getPlantGroupValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantGroupPropertyChangeAdapter(model));

        
        plantTypeCombox.setItems(model.getPlantTypes());
        plantTypeCombox.getSelectionModel().select(model.getPlantSubGroupValueWrapper().getValue());
        model.getPlantTypes().addListener(new PlantTypeListChangeAdapter(plantTypeCombox, model));
        model.getPlantSubGroupValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantTypeSelectionPropertyChangeAdapter(model, plantTypeCombox));
        plantTypeCombox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getPlantSubGroupValueWrapper())); 
        
        plantVarietyCombobox.setItems(model.getPlantVarieties());
        plantVarietyCombobox.getSelectionModel().select(model.getPlantVarietyValueWrapper().getValue());        
        plantVarietyCombobox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getPlantVarietyValueWrapper()));
        model.getPlantVarieties().addListener(new PlantVarietyListChangeAdapter(plantVarietyCombobox, model));
        model.getPlantVarietyValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantVarietyPropertyChangeAdapter(plantVarietyCombobox));

        QuantityTypeRadioButton singlePlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton multiplePlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton estimatedPlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton notCountingRadioButton = new QuantityTypeRadioButton();
        plantNumberTypeHbox.getChildren().addAll(singlePlantRadioButton, multiplePlantRadioButton, estimatedPlantRadioButton, notCountingRadioButton);
        singlePlantRadioButton.setType(PlantsQuantity.Type.SINGLE);
        multiplePlantRadioButton.setType(PlantsQuantity.Type.MULTIPLE);
        estimatedPlantRadioButton.setType(PlantsQuantity.Type.ESTIMATION);
        notCountingRadioButton.setType(PlantsQuantity.Type.NO_COUNTING);

        switch (model.getQuantityTypeValueWrapper().getValue()) {
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

        Spinner<Integer> plantNumberSpinner = new Spinner<>();
        plantNumberHbox.getChildren().add(plantNumberSpinner);
        IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(0, 100000);
        factory.setValue(model.getQuantityValueWrapper().getValue());
        plantNumberSpinner.setValueFactory(factory);
        PlantsQuantity.Type type = model.getQuantityTypeValueWrapper().getValue();
        plantNumberSpinner.setDisable(type == PlantsQuantity.Type.SINGLE || type == PlantsQuantity.Type.NO_COUNTING);
        ((IntegerSpinnerValueFactory) plantNumberSpinner.getValueFactory()).setMin(0);

        DateTimePicker datePlantedPicker = new DateTimePicker();
        datePlantedHbox.getChildren().add(datePlantedPicker);
        datePlantedPicker.setDateTimeValue(model.getStartTimeValueWrapper().getValue());

        growingMediumCombobox.setItems(model.getGrowingMediums());
        growingMediumCombobox.getSelectionModel().select(model.getGrowingMediumValueWrapper().getValue());

        Location location = model.getLocationValueWrapper().getValue();
        locationTitleLabel.setText(location == null ? "Not Specified" : location.getTitle());
        locationInformationTextArea.setText(location == null ? "" : location.getInformation());
        locationInformationTextArea.setDisable(true);
        editLocationButton.setText(location == null ? "Add Location" : "Edit Location");
        boolean isAlive = model.getIsAliveValueWrapper().getValue();
        DateTimePicker terminationDatePicker = new DateTimePicker();
        terminationDateHbox.getChildren().add(terminationDatePicker);
        if (!isAlive) {
            terminationDatePicker.setDateTimeValue(LocalDateTime.now());
            terminationTextArea.setText("");
        }
        
        terminationDatePicker.setVisible(!isAlive);
        terminationTextArea.setVisible(!isAlive);
        isAliveCheckBox.setSelected(isAlive);
        terminationDatePicker.setDateTimeValue(model.getTerminationTimeValueWrapper().getValue());
        terminationDatePicker.setDayCellFactory(new CurrentMaxDayCellFactory());

        eventListView.setItems(model.getGvents());
        eventListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        eventListView.getSelectionModel().select(model.getSelectedEventValueWrapper().getValue());
        editEventButton.setDisable(model.getSelectedEventValueWrapper().getValue() == null);
        removeEventButton.setDisable(model.getSelectedEventValueWrapper().getValue() == null);

        taskListView.setItems(model.getTasks());
        taskListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        taskListView.getSelectionModel().select(model.getSelectedTaskValueWrapper().getValue());
        editTaskButton.setDisable(model.getSelectedTaskValueWrapper().getValue() == null);
        removeTaskButton.setDisable(model.getSelectedTaskValueWrapper().getValue() == null);

        issueListView.setItems(model.getGrowingIssues());
        issueListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        issueListView.getSelectionModel().select(model.getSelectedGrowingIssueValueWrapper().getValue());
        editIssueButton.setDisable(model.getSelectedGrowingIssueValueWrapper().getValue() == null);
        removeIssueButton.setDisable(model.getSelectedGrowingIssueValueWrapper().getValue() == null);

        observationListView.setItems(model.getGrowingObservations());
        observationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        observationListView.getSelectionModel().select(model.getSelectedGrowingObservationValueWrapper().getValue());
        editObservationButton.setDisable(model.getSelectedGrowingObservationValueWrapper().getValue() == null);
        removeObservationButton.setDisable(model.getSelectedGrowingObservationValueWrapper().getValue() == null);

        //Group the radio buttons.
        ToggleGroup toggleGroup = new ToggleGroup();
        singlePlantRadioButton.setToggleGroup(toggleGroup);
        multiplePlantRadioButton.setToggleGroup(toggleGroup);
        estimatedPlantRadioButton.setToggleGroup(toggleGroup);
        notCountingRadioButton.setToggleGroup(toggleGroup);

        //Add change listeners to components.
       
        addPlantTypeButton.setOnAction(new AddPlantTypeEventHandler(model));
        
        addPlantVarietyButton.setOnAction(new AddVarityToPlantEventHandler(model));
        addGrowingMediumButton.setOnAction(new AddPlantsGrowingMediumEventHandler(model));

        toggleGroup.selectedToggleProperty().addListener(new PlantNumberTypeChangeAdapter(model));
        plantNumberSpinner.valueProperty().addListener(new PlantNumberChangeAdapter(model));

        datePlantedPicker.dateTimeValueProperty().addListener(new PlantedDateChangeAdapter(model));
        growingMediumCombobox.selectionModelProperty().addListener(new GrowingMediumChangeAdapter(model));
        editLocationButton.setOnAction(new EditPlantLocationEventHandler(model));
        isAliveCheckBox.selectedProperty().addListener(new IsAliveChangeAdapter(model));
        terminationDatePicker.dateTimeValueProperty().addListener(new TerminationDateChangeAdapter(model));
        terminationTextArea.textProperty().addListener(new TerminationReasonChangeAdapter(model));
        eventListView.selectionModelProperty().addListener(new EventSelectionChangeAdapter(model));
        addEventButton.setOnAction(new AddPlantsGventEventHandler(model));
        editEventButton.setOnAction(new EditPlantsGventEventHandler(model, eventListView));
        removeEventButton.setOnAction(new RemovePlantsEventEventHandler(model));
        eventListView.selectionModelProperty().addListener(new EventSelectionChangeAdapter(model));
        addTaskButton.setOnAction(new AddPlantsTaskEventHandler(model));
        editTaskButton.setOnAction(new EditPlantsTaskEventHandler(model, taskListView));
        removeEventButton.setOnAction(new RemovePlantsTaskEventHandler(model));
        taskListView.selectionModelProperty().addListener(new TaskSelectionChangeAdapter(model));
        addIssueButton.setOnAction(new AddPlantsIssueEventHandler(model));
        editIssueButton.setOnAction(new EditPlantsIssueEventHandler(model, issueListView));
        removeIssueButton.setOnAction(new RemovePlantsIssueEventHandler(model));
        observationListView.selectionModelProperty().addListener(new ObservationSelectionChangeAdapter(model));
        addObservationButton.setOnAction(new AddPlantsObservationEventHandler(model));
        editObservationButton.setOnAction(new EditPlantsObservationEventHandler(model, observationListView));
        removeObservationButton.setOnAction(new RemovePlantsObservationEventHandler(model));

        //Add change listeners to model.

        
        model.addPropertyChangeListener(QUANTITY_TYPE_PROPERTY, new QuantityTypePropertyChangeAdapter(plantNumberSpinner));
        model.addPropertyChangeListener(SELECTED_GROWING_MEDIUM_RPOPERTY, new GrowingMediumSelectionPropertyChangeDapter(growingMediumCombobox));
        model.addPropertyChangeListener(LOCATION_PROPERTY, new LocationPropertyChangeAdapter(locationTitleLabel, locationInformationTextArea, editLocationButton));
        model.addPropertyChangeListener(ALIVE_PROPERTY, new AlivePropertyChangeAdapter(terminationDatePicker, terminationTextArea, terminationDatePickerLabel, terminationReasonTextAreaLabel));
    }
}
