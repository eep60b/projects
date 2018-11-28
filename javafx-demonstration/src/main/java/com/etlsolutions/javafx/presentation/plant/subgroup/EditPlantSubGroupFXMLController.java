package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.gvent.ValueChangeAdapter;
import static com.etlsolutions.javafx.presentation.plant.subgroup.AbstractPlantSubGroupDataModel.*;
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
public class EditPlantSubGroupFXMLController extends DataUnitFXMLController<PlantSubGroup, EditPlantSubGroupDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private Label plantGroupCombox;

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
        plantGroupCombox.getSelectionModel().select(model.getSelectedPlantGroupValueWrapper().getValue());

        removePlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        editPlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        plantVarityListView.setItems(model.getVarieties());
        plantVarityListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        plantVarityListView.getSelectionModel().select(model.getSelectedVarietyValueWrapper().getValue());

        plantGroupCombox.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedPlantGroupValueWrapper()));
        addPlantVarietyButton.setOnAction(new CreatePlantVarietyEventhandler(model));
        removePlantVarietyButton.setOnAction(new RemoveEventHandler(model, REMOVE_VARIETY_ID));
        editPlantVarietyButton.setOnAction(new EditPlantVarietyEventhandler(model,removePlantVarietyButton, editPlantVarietyButton, plantVarityListView));
        plantVarityListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedVarietyValueWrapper()));

        model.getSelectedVarietyValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new PlantVarietySelectionProertyChangeAdapter(editPlantVarietyButton, removePlantVarietyButton, plantVarityListView));
        model.getVarieties().addListener(new VarietyListChangeAdapter(model, plantVarityListView));
        model.getSelectedVarietyValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new VarietyPropertyChangeAdapter(plantVarityListView));
    }
}
