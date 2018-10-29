package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.presentation.plant.SelectPlantGroupChangeAdapter;
import com.etlsolutions.javafx.data.plant.PlantGroup;
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
public class AddPlantTypeFXMLController extends DataUnitFXMLController<AddPlantTypeDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private ComboBox<PlantGroup> groupComboBox;

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

        groupComboBox.setItems(model.getPlantGroups());
        groupComboBox.getSelectionModel().select(model.getSelectedPlantGroup());

        removeVarityButton.setDisable(model.getSelectedVariety() == null);
        editVarityButton.setDisable(model.getSelectedVariety() == null);
        varityListView.setItems(model.getVarieties());
        varityListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        varityListView.getSelectionModel().select(model.getSelectedVariety());

        groupComboBox.getSelectionModel().selectedItemProperty().addListener(new SelectPlantGroupChangeAdapter(model));
        addVarityButton.setOnAction(new AddPlantVarietyEventhandler(model));
        removeVarityButton.setOnAction(new RemoveEventHandler(model, REMOVE_VARIETY_ID));
        editVarityButton.setOnAction(new EditPlantVarietyEventhandler(model, model.getSelectedVariety()));
        varityListView.getSelectionModel().selectedItemProperty().addListener(new PlantVarietySelectionChangeAdapter(model));

        model.addPropertyChangeListener(SELECTED_VARIETY_PROPERTY, new PlantVarietySelectionProertyChangeAdapter(editVarityButton, removeVarityButton, varityListView));
        model.getVarieties().addListener(new VarietyListChangeAdapter(model, varityListView));
        model.addPropertyChangeListener(VARIETY_CHANGE_PROPERTY, new VarietyPropertyChangeAdapter(varityListView));
    }
}
