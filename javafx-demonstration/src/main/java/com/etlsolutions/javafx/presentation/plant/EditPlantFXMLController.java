package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.CurrentMaxDayCellFactory;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.data.plant.Plants;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import static com.etlsolutions.javafx.data.plant.PlantsQuantity.Type.SINGLE;
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.ComboBoxSelectionPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.log.growingissue.AddGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.log.growingissue.EditGrowingIssueDataModel;
import com.etlsolutions.javafx.presentation.log.task.AddTaskDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingobservation.AddGrowingObservationDataModel;
import com.etlsolutions.javafx.presentation.menu.add.growingobservation.EditGrowingObservationDataModel;
import com.etlsolutions.javafx.presentation.menu.add.gvent.AddGventDataModel;
import com.etlsolutions.javafx.presentation.menu.add.gvent.EditGventDataModel;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import com.etlsolutions.javafx.presentation.menu.edit.task.EditTaskDataModel;
import static com.etlsolutions.javafx.presentation.plant.AddPlantDataModel.*;
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
public class EditPlantFXMLController extends DataUnitFXMLController<Plants, EditPlantDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private Pane imageTilePane;

    @FXML
    private Label plantGroupTitleLabel;

    @FXML
    private Label plantSubGroupTitleLabel;

    @FXML
    private Label plantVarietyTitleLabel;

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

        plantGroupTitleLabel.setText(model.getPlantGroup().getTitle());
        plantSubGroupTitleLabel.setText(model.getPlantSubGroup().getTitle());
        plantVarietyTitleLabel.setText(model.getPlantVariety().getTitle());

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
        terminationTextArea.setVisible(!isAlive);
        isAliveCheckBox.setSelected(isAlive);
        model.getIsAliveValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new AlivePropertyChangeAdapter(terminationDatePicker, terminationTextArea, terminationDatePickerLabel, terminationReasonTextAreaLabel));

        terminationDatePicker.setDateTimeValue(model.getTerminationTimeValueWrapper().getValue());
        terminationDatePicker.setDayCellFactory(new CurrentMaxDayCellFactory());

        gventListView.setItems(model.getGvents());
        gventListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gventListView.getSelectionModel().select(model.getSelectedEventValueWrapper().getValue());
        editGventButton.setDisable(model.getSelectedEventValueWrapper().getValue() == null);
        removeGventButton.setDisable(model.getSelectedEventValueWrapper().getValue() == null);

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


        toggleGroup.selectedToggleProperty().addListener(new PlantNumberTypeChangeAdapter(model));
        plantNumberSpinner.valueProperty().addListener(new ValueChangeAdapter<>(model.getQuantityValueWrapper()));
        model.getQuantityTypeValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new QuantityTypePropertyChangeAdapter(plantNumberSpinner));

        datePlantedPicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getStartTimeValueWrapper()));
        growingMediumCombobox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getGrowingMediumValueWrapper()));

        isAliveCheckBox.selectedProperty().addListener(new ValueChangeAdapter<>(model.getIsAliveValueWrapper()));
        terminationDatePicker.dateTimeValueProperty().addListener(new ValueChangeAdapter<>(model.getTerminationTimeValueWrapper()));
        terminationTextArea.textProperty().addListener(new ValueChangeAdapter<>(model.getTerminationReasonValueWrapper()));

        gventListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedEventValueWrapper()));
        addGventButton.setOnAction(new AddItemEventHandler<>(model.getGvents(), model.getSelectedEventValueWrapper(), new AddGventDataModel()));
        EditGventDataModel gm = new EditGventDataModel(model.getSelectedEventValueWrapper().getValue());
        gm.addPropertyChangeListener(EditGventDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(gventListView));
        editGventButton.setOnAction(new EditItemEventHandler(gm));
        removeGventButton.setOnAction(new RemoveEventHandler(model, REMOVE_GVENT_ID));

        taskListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedTaskValueWrapper()));
        addTaskButton.setOnAction(new AddItemEventHandler<>(model.getTasks(), model.getSelectedTaskValueWrapper(), new AddTaskDataModel()));
        EditTaskDataModel tm = new EditTaskDataModel(model.getSelectedTaskValueWrapper().getValue());
        tm.addPropertyChangeListener(EditTaskDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(taskListView));
        editTaskButton.setOnAction(new EditItemEventHandler(tm));
        removeTaskButton.setOnAction(new RemoveEventHandler(model, REMOVE_TASK_ID));

        issueListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedGrowingIssueValueWrapper()));
        addIssueButton.setOnAction(new AddItemEventHandler<>(model.getGrowingIssues(), model.getSelectedGrowingIssueValueWrapper(), new AddGrowingIssueDataModel()));
        EditGrowingIssueDataModel im = new EditGrowingIssueDataModel(model.getSelectedGrowingIssueValueWrapper().getValue());
        im.addPropertyChangeListener(EditGrowingIssueDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(issueListView));        
        editIssueButton.setOnAction(new EditItemEventHandler(im));
        removeIssueButton.setOnAction(new RemoveEventHandler(model, REMOVE_ISSUE_ID));

        observationListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedGrowingObservationValueWrapper()));
        addObservationButton.setOnAction(new AddItemEventHandler<>(model.getGrowingObservations(), model.getSelectedGrowingObservationValueWrapper(), new AddGrowingObservationDataModel()));
        EditGrowingObservationDataModel om = new EditGrowingObservationDataModel(model.getSelectedGrowingObservationValueWrapper().getValue());
        om.addPropertyChangeListener(EditGrowingObservationDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(observationListView));
        editObservationButton.setOnAction(new EditItemEventHandler(om));
        removeObservationButton.setOnAction(new RemoveEventHandler(model, REMOVE_OBSERVATION_ID));
    }
}
