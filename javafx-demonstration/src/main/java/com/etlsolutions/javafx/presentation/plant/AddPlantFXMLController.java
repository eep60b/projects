package com.etlsolutions.javafx.presentation.plant;

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
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.ComboBoxListChangeAdapter;
import com.etlsolutions.javafx.presentation.ComboBoxSelectionPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.log.growingissue.AddGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.log.task.AddTaskDataModel;
import com.etlsolutions.javafx.presentation.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.presentation.log.growingobservation.AddGrowingObservationDataModel;
import com.etlsolutions.javafx.presentation.log.gvent.AddGventDataModel;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import static com.etlsolutions.javafx.presentation.plant.AddPlantDataModel.*;
import com.etlsolutions.javafx.presentation.plant.plantvariety.AddVarietyDataModel;
import com.etlsolutions.javafx.presentation.plant.subgroup.AddPlantSubGroupDataModel;
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
public class AddPlantFXMLController extends DataUnitFXMLController<Plants, AddPlantDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private Pane imageTilePane;

    @FXML
    private ComboBox<PlantGroup> plantGroupCombox;

    @FXML
    private ComboBox<PlantSubGroup> plantSubGroupCombox;

    @FXML
    private Button addPlantSubGroupButton;

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
    private ListView<Gvent> gventListView;

    @FXML
    private Label terminationReasonTextAreaLabel;

    @FXML
    private Button addGventButton;

    @FXML
    private Button editGventButton;

    @FXML
    private Button removeGventButton;

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

        plantSubGroupCombox.setItems(model.getPlantSubGroups());
        plantSubGroupCombox.getSelectionModel().select(model.getPlantSubGroupValueWrapper().getValue());
        plantSubGroupCombox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getPlantSubGroupValueWrapper()));
        model.getPlantSubGroups().addListener(new ComboBoxListChangeAdapter<>(model.getPlantSubGroups(), plantSubGroupCombox, model.getPlantSubGroupValueWrapper()));
        model.getPlantSubGroupValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ComboBoxSelectionPropertyChangeAdapter(plantSubGroupCombox));
        addPlantSubGroupButton.setOnAction(new AddItemEventHandler<>(model.getPlantSubGroups(), model.getPlantSubGroupValueWrapper(), new AddPlantSubGroupDataModel(model.getPlantGroupValueWrapper().getValue())));

        plantVarietyCombobox.setItems(model.getPlantVarieties());
        plantVarietyCombobox.getSelectionModel().select(model.getPlantVarietyValueWrapper().getValue());
        plantVarietyCombobox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getPlantVarietyValueWrapper()));
        model.getPlantVarieties().addListener(new ComboBoxListChangeAdapter<>(model.getPlantVarieties(), plantVarietyCombobox, model.getPlantVarietyValueWrapper()));
        model.getPlantVarietyValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ComboBoxSelectionPropertyChangeAdapter(plantVarietyCombobox));
        addPlantVarietyButton.setOnAction(new AddItemEventHandler<>(model.getPlantVarieties(), model.getPlantVarietyValueWrapper(), new AddVarietyDataModel(model.getPlantSubGroupValueWrapper().getValue())));

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
        ToggleGroup toggleGroup = new ToggleGroup();
        singlePlantRadioButton.setToggleGroup(toggleGroup);
        multiplePlantRadioButton.setToggleGroup(toggleGroup);
        estimatedPlantRadioButton.setToggleGroup(toggleGroup);
        notCountingRadioButton.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener(new PlantNumberTypeChangeAdapter(model));
        
        Spinner<Integer> plantNumberSpinner = new Spinner<>();
        plantNumberHbox.getChildren().add(plantNumberSpinner);
        IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(0, 100000);
        factory.setValue(model.getQuantityValueWrapper().getValue());
        plantNumberSpinner.setValueFactory(factory);
        PlantsQuantity.Type type = model.getQuantityTypeValueWrapper().getValue();
        plantNumberSpinner.setDisable(type == PlantsQuantity.Type.SINGLE || type == PlantsQuantity.Type.NO_COUNTING);
        ((IntegerSpinnerValueFactory) plantNumberSpinner.getValueFactory()).setMin(0);
        plantNumberSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getQuantityValueWrapper()));
        model.getQuantityTypeValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new QuantityTypePropertyChangeAdapter(plantNumberSpinner));
        
        DateTimePicker datePlantedPicker = new DateTimePicker();
        datePlantedHbox.getChildren().add(datePlantedPicker);
        datePlantedPicker.setDateTimeValue(model.getStartTimeValueWrapper().getValue());
        datePlantedPicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getStartTimeValueWrapper()));
        
        growingMediumCombobox.setItems(model.getGrowingMediums());
        growingMediumCombobox.getSelectionModel().select(model.getGrowingMediumValueWrapper().getValue());
        model.getGrowingMediumValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ComboBoxSelectionPropertyChangeAdapter<>(growingMediumCombobox));
        growingMediumCombobox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getGrowingMediumValueWrapper()));
        addGrowingMediumButton.setOnAction(new AddItemEventHandler<>(model.getGrowingMediums(), model.getGrowingMediumValueWrapper(), new AddGrowingMediumDataModel()));

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
        model.getLocationValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new LocationPropertyChangeAdapter(locationTitleLabel, locationInformationTextArea, editLocationButton));
        editLocationButton.setOnAction(new EditPlantLocationEventHandler(model, locationTitleLabel, locationInformationTextArea));

        terminationDatePicker.setVisible(!isAlive);

        isAliveCheckBox.setSelected(isAlive);
        model.getIsAliveValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AlivePropertyChangeAdapter(terminationDatePicker, terminationTextArea, terminationDatePickerLabel, terminationReasonTextAreaLabel));
        isAliveCheckBox.selectedProperty().addListener(new ValueChangeAdapter<>(model.getIsAliveValueWrapper()));
        
        terminationDatePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getTerminationTimeValueWrapper()));        
        terminationDatePicker.setDateTimeValue(model.getTerminationTimeValueWrapper().getValue());
        terminationDatePicker.setDayCellFactory(new CurrentMaxDayCellFactory());
        
        terminationTextArea.setVisible(!isAlive);
        terminationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getTerminationReasonValueWrapper()));
        
        gventListView.setItems(model.getGvents());
        gventListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gventListView.getSelectionModel().select(model.getSelectedEventValueWrapper().getValue());
        gventListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedEventValueWrapper()));
        addGventButton.setOnAction(new AddItemEventHandler<>(model.getGvents(), model.getSelectedEventValueWrapper(), new AddGventDataModel()));
        removeGventButton.setOnAction(new RemoveEventHandler(model, REMOVE_GVENT_ID));
        PlantGventPropertyChangeAdapter gventAdapter = new PlantGventPropertyChangeAdapter(gventListView, editGventButton, removeGventButton);    
        gventAdapter.process(model.getSelectedEventValueWrapper());
        model.getSelectedEventValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, gventAdapter);
                
        taskListView.setItems(model.getTasks());
        taskListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        taskListView.getSelectionModel().select(model.getSelectedTaskValueWrapper().getValue());
        taskListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedTaskValueWrapper()));
        addTaskButton.setOnAction(new AddItemEventHandler<>(model.getTasks(), model.getSelectedTaskValueWrapper(), new AddTaskDataModel()));
        removeTaskButton.setOnAction(new RemoveEventHandler(model, REMOVE_TASK_ID));
        PlantTaskPropertyChangeAdapter taskAdapter = new PlantTaskPropertyChangeAdapter(taskListView, editTaskButton, removeTaskButton);    
        taskAdapter.process(model.getSelectedTaskValueWrapper());
        model.getSelectedTaskValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, taskAdapter);
        
        issueListView.setItems(model.getGrowingIssues());
        issueListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        issueListView.getSelectionModel().select(model.getSelectedGrowingIssueValueWrapper().getValue());
        issueListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedGrowingIssueValueWrapper()));
        addIssueButton.setOnAction(new AddItemEventHandler<>(model.getGrowingIssues(), model.getSelectedGrowingIssueValueWrapper(), new AddGrowingIssueDataModel()));
        removeIssueButton.setOnAction(new RemoveEventHandler(model, REMOVE_ISSUE_ID));            
        PlantGrowingIssuePropertyChangeAdapter issueAdapter = new PlantGrowingIssuePropertyChangeAdapter(issueListView, editIssueButton, removeIssueButton);    
        issueAdapter.process(model.getSelectedGrowingIssueValueWrapper());
        model.getSelectedGrowingIssueValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, issueAdapter);
   
        observationListView.setItems(model.getGrowingObservations());
        observationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        observationListView.getSelectionModel().select(model.getSelectedGrowingObservationValueWrapper().getValue());
        observationListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedGrowingObservationValueWrapper()));
        addObservationButton.setOnAction(new AddItemEventHandler<>(model.getGrowingObservations(), model.getSelectedGrowingObservationValueWrapper(), new AddGrowingObservationDataModel()));
        removeObservationButton.setOnAction(new RemoveEventHandler(model, REMOVE_OBSERVATION_ID));
        PlantObservationPropertyChangeAdapter observationAdapter = new PlantObservationPropertyChangeAdapter(observationListView, editObservationButton, removeObservationButton);    
        observationAdapter.process(model.getSelectedGrowingObservationValueWrapper());
        model.getSelectedGrowingObservationValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, observationAdapter);
    }
}
