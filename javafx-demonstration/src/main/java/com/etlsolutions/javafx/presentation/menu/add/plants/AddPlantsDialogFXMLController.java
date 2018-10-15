package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.CurrentMaxDayCellFactory;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.area.subarea.location.Location;
import com.etlsolutions.javafx.data.log.GrowingIssue;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.data.GrowingMedium;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.data.plant.PlantsQuantity;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.CancelEventHandler;
import com.etlsolutions.javafx.presentation.DateTimePicker;
import com.etlsolutions.javafx.presentation.AbstractFXMLController;
import com.etlsolutions.javafx.presentation.InformationChangeAdapter;
import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import com.etlsolutions.javafx.presentation.SaveExitEventHandler;
import com.etlsolutions.javafx.presentation.TitleChangeAdapter;
import com.etlsolutions.javafx.presentation.ValidationPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.imagelink.AddImageDataModel;
import com.etlsolutions.javafx.presentation.imagelink.EditImageInformationDataModel;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToBeginEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToEndEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToLeftEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.MoveImageLinkToRightEventHandler;
import com.etlsolutions.javafx.presentation.imagelink.RemoveImageLinkEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumDataModel;
import static com.etlsolutions.javafx.presentation.menu.add.plants.AddPlantsDataModel.*;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeEventHandler;
import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import java.time.LocalDateTime;
import java.util.List;
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

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantsDialogFXMLController extends AbstractFXMLController<AddPlantsDataModel> {

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
    private TextField locationTitleTextField;

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
        titleTextField.setText(model.getTitle());
        plantGroupCombox.setItems(model.getPlantGroups());
        plantGroupCombox.getSelectionModel().select(model.getSelectedPlantGroup());
        plantTypeCombox.setItems(model.getPlantTypes());
        plantTypeCombox.getSelectionModel().select(model.getSelectedPlantType());
        plantVarietyCombobox.setItems(model.getPlantVarieties());
        
        QuantityTypeRadioButton singlePlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton multiplePlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton estimatedPlantRadioButton = new QuantityTypeRadioButton();
        QuantityTypeRadioButton notCountingRadioButton = new QuantityTypeRadioButton();
        plantNumberTypeHbox.getChildren().addAll(singlePlantRadioButton, multiplePlantRadioButton, estimatedPlantRadioButton, notCountingRadioButton);
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
        
        Spinner<Integer> plantNumberSpinner = new Spinner<>();
        plantNumberHbox.getChildren().add(plantNumberSpinner);
        IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(0, 100000);
        factory.setValue(model.getPlantNumber());
        plantNumberSpinner.setValueFactory(factory);
        PlantsQuantity.Type type = model.getQuantityType();
        plantNumberSpinner.setDisable(type == PlantsQuantity.Type.SINGLE || type == PlantsQuantity.Type.NO_COUNTING);
        ((IntegerSpinnerValueFactory) plantNumberSpinner.getValueFactory()).setMin(0);

        informationTextArea.setText(model.getInformation());

        ImageLink selectedImageLink = model.getSelectedImageLink();
        removeImageButton.setDisable(selectedImageLink == null);
        List<ImageLink> imageLinks = model.getImageLinks();
        moveToBeginImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToLeftImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(0));
        moveToEndImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        moveToRightImageButton.setDisable(selectedImageLink == null || selectedImageLink == imageLinks.get(imageLinks.size() - 1));
        editImageButton.setDisable(selectedImageLink == null);

        DateTimePicker datePlantedPicker = new DateTimePicker();
        datePlantedHbox.getChildren().add(datePlantedPicker);        
        datePlantedPicker.setDateTimeValue(model.getPlantedDate());
        
        growingMediumCombobox.setItems(model.getGrowingMediums());
        growingMediumCombobox.getSelectionModel().select(model.getSelectedGrowingMedium());

        titleTextField.textProperty().addListener(new TitleChangeAdapter(model));
        plantGroupCombox.selectionModelProperty().addListener(new SelectPlantGroupChangeAdapter(model));
        plantTypeCombox.selectionModelProperty().addListener(new PlantTypeChangeAdapter(model));
        addPlantTypeButton.setOnAction(new AddPlantTypeEventHandler());
        addPlantVarietyButton.setOnAction(new FXMLActionEventHandler<>(new AddVarityToPlantsDialogDataModel(model)));
        addGrowingMediumButton.setOnAction(new AddPlantsGrowingMediumEventHandler(model));
        Location location = model.getLocation();
        locationTitleTextField.setText(location == null ? "Not Specified" : location.getTitle());
        locationTitleTextField.setDisable(true);
        locationInformationTextArea.setText(location == null ? "" : location.getInformation());
        locationInformationTextArea.setDisable(true);
        editLocationButton.setText(location == null ? "Add Location" : "Edit Location");
        boolean isAlive = model.isAlive();
        DateTimePicker terminationDatePicker = new DateTimePicker();
        terminationDateHbox.getChildren().add(terminationDatePicker);
        if (!isAlive) {
            terminationDatePicker.setDateTimeValue(LocalDateTime.now());
            terminationTextArea.setText("");
        }
        terminationDatePicker.setVisible(!isAlive);
        terminationTextArea.setVisible(!isAlive);
        isAliveCheckBox.setSelected(isAlive);
        terminationDatePicker.setDateTimeValue(model.getTerminationDate());
        terminationDatePicker.setDayCellFactory(new CurrentMaxDayCellFactory());

        eventListView.setItems(model.getEvents());
        eventListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        eventListView.getSelectionModel().select(model.getSelectedEvent());
        editEventButton.setDisable(model.getSelectedEvent() == null);
        removeEventButton.setDisable(model.getSelectedEvent() == null);

        taskListView.setItems(model.getTasks());
        taskListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        taskListView.getSelectionModel().select(model.getSelectedTask());
        editTaskButton.setDisable(model.getSelectedTask() == null);
        removeTaskButton.setDisable(model.getSelectedTask() == null);

        issueListView.setItems(model.getIssues());
        issueListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        issueListView.getSelectionModel().select(model.getSelectedGrowingIssue());
        editIssueButton.setDisable(model.getSelectedGrowingIssue() == null);
        removeIssueButton.setDisable(model.getSelectedGrowingIssue() == null);

        observationListView.setItems(model.getObservations());
        observationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        observationListView.getSelectionModel().select(model.getSelectedGrowingObservation());
        editObservationButton.setDisable(model.getSelectedGrowingObservation() == null);
        removeObservationButton.setDisable(model.getSelectedGrowingObservation() == null);

        errorMessageLabel.setText(model.getErrorMessage());
        okButton.setDisable(!model.isValid());

        //Group the radio buttons.
        ToggleGroup toggleGroup = new ToggleGroup();
        singlePlantRadioButton.setToggleGroup(toggleGroup);
        multiplePlantRadioButton.setToggleGroup(toggleGroup);
        estimatedPlantRadioButton.setToggleGroup(toggleGroup);
        notCountingRadioButton.setToggleGroup(toggleGroup);

        //Add change listeners to components.
        toggleGroup.selectedToggleProperty().addListener(new PlantNumberTypeChangeAdapter(model));
        plantNumberSpinner.valueProperty().addListener(new PlantNumberChangeAdapter(model));
        informationTextArea.textProperty().addListener(new InformationChangeAdapter(model));

        addImageButton.setOnAction(new FXMLActionEventHandler<>(new AddImageDataModel(model)));
        removeImageButton.setOnAction(new RemoveImageLinkEventHandler(model));
        moveToBeginImageButton.setOnAction(new MoveImageLinkToBeginEventHandler(model));
        moveToLeftImageButton.setOnAction(new MoveImageLinkToLeftEventHandler(model));
        moveToEndImageButton.setOnAction(new MoveImageLinkToEndEventHandler(model));
        moveToRightImageButton.setOnAction(new MoveImageLinkToRightEventHandler(model));
        editImageButton.setOnAction(new FXMLActionEventHandler<>(new EditImageInformationDataModel(model.getSelectedImageLink())));
        datePlantedPicker.dateTimeValueProperty().addListener(new PlantedDateChangeAdapter(model));
        growingMediumCombobox.selectionModelProperty().addListener(new GrowingMediumChangeAdapter(model));
        editLocationButton.setOnAction(new EditPlantLocationEventHandler(model));
        isAliveCheckBox.selectedProperty().addListener(new IsAliveChangeAdapter(model));
        terminationDatePicker.dateTimeValueProperty().addListener(new TerminationDateChangeAdapter(model));
        terminationTextArea.textProperty().addListener(new TerminationReasonChangeAdapter(model));
        eventListView.selectionModelProperty().addListener(new EventSelectionChangeAdapter(model));
        addEventButton.setOnAction(new AddPlantsGventEventHandler(model));
        editEventButton.setOnAction(new EditPlantsEventEventHandler(model, eventListView));
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
        okButton.setOnAction(new SaveExitEventHandler(model, stage));
        cancelButton.setOnAction(new CancelEventHandler(stage));

        //Add change listeners to model.
        model.addPropertyChangeListener(SELECTED_PLANT_GROUP_PROPERTY, new PlantGroupSelectionPropertyChangeAdapter(plantTypeCombox));
        model.addPropertyChangeListener(QUANTITY_TYPE_PROPERTY, new QuantityTypePropertyChangeAdapter(plantNumberSpinner));
        model.addPropertyChangeListener(SELECTED_GROWING_MEDIUM_RPOPERTY, new GrowingMediumSelectionPropertyChangeDapter(growingMediumCombobox));
        model.addPropertyChangeListener(LOCATION_PROPERTY, new LocationPropertyChangeAdapter(locationTitleTextField, locationInformationTextArea, editLocationButton));
        model.addPropertyChangeListener(ALIVE_PROPERTY, new AlivePropertyChangeAdapter(terminationDatePicker, terminationTextArea, terminationDatePickerLabel, terminationReasonTextAreaLabel));
        model.addPropertyChangeListener(TITLE_PROPERTY, new ValidationPropertyChangeAdapter(errorMessageLabel, okButton));
    }
}
