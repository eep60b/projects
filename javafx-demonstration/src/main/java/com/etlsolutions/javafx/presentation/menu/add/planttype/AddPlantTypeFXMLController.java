package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantType;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import static com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDataModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class AddPlantTypeFXMLController extends DataUnitFXMLController<PlantType, AddPlantTypeDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<PlantGroup> plantGroupCombox;

    @FXML
    private Button addPlantVarietyButton;

    @FXML
    private Button removePlantVarietyButton;

    @FXML
    private Button editPlantVarietyButton;

    @FXML
    private ListView plantVarityListView;

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

        plantGroupCombox.setItems(model.getPlantGroups());
        plantGroupCombox.getSelectionModel().select(model.getSelectedPlantGroup());

        removePlantVarietyButton.setDisable(model.getSelectedVariety() == null);
        editPlantVarietyButton.setDisable(model.getSelectedVariety() == null);
        plantVarityListView.setItems(model.getVarieties());
        plantVarityListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        plantVarityListView.getSelectionModel().select(model.getSelectedVariety());

        plantGroupCombox.getSelectionModel().selectedItemProperty().addListener(new SelectPlantGroupChangeAdapter(model));
        addPlantVarietyButton.setOnAction(new CreatePlantVarietyEventhandler(model));
        removePlantVarietyButton.setOnAction(new RemoveEventHandler(model, REMOVE_VARIETY_ID));
        editPlantVarietyButton.setOnAction(new EditPlantVarietyEventhandler(model, model.getSelectedVariety()));
        plantVarityListView.getSelectionModel().selectedItemProperty().addListener(new PlantVarietySelectionChangeAdapter(model));

        model.addPropertyChangeListener(SELECTED_VARIETY_PROPERTY, new PlantVarietySelectionProertyChangeAdapter(editPlantVarietyButton, removePlantVarietyButton, plantVarityListView));
        model.getVarieties().addListener(new VarietyListChangeAdapter(model, plantVarityListView));
        model.addPropertyChangeListener(VARIETY_CHANGE_PROPERTY, new VarietyPropertyChangeAdapter(plantVarityListView));
    }
}
