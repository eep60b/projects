package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.ListViewListChangeAdapter;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.ValueChangeButtonPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.log.gvent.ValueChangeAdapter;
import com.etlsolutions.javafx.presentation.plant.plantvariety.CreateVarietyDataModel;
import com.etlsolutions.javafx.presentation.plant.plantvariety.EditVarietyDataModel;
import static com.etlsolutions.javafx.presentation.plant.subgroup.AbstractPlantSubGroupDataModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Label plantGroupTitleLabel;

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

        plantGroupTitleLabel.setText(model.getPlantGroupTitle());
        
        removePlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        editPlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        plantVarityListView.setItems(model.getVarieties());
        plantVarityListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        plantVarityListView.getSelectionModel().select(model.getSelectedVarietyValueWrapper().getValue());
        plantVarityListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedVarietyValueWrapper()));
        addPlantVarietyButton.setOnAction(new AddItemEventHandler<>(model.getVarieties(), model.getSelectedVarietyValueWrapper(), new CreateVarietyDataModel()));        
        EditVarietyDataModel vm = new EditVarietyDataModel(model.getSelectedVarietyValueWrapper().getValue());
        vm.addPropertyChangeListener( EditVarietyDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(plantVarityListView));        
        editPlantVarietyButton.setOnAction(new EditItemEventHandler(vm));
        removePlantVarietyButton.setOnAction(new RemoveEventHandler(model, REMOVE_VARIETY_ID));
        model.getSelectedVarietyValueWrapper().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValueChangeButtonPropertyChangeAdapter<>(editPlantVarietyButton, removePlantVarietyButton));
        model.getVarieties().addListener(new ListViewListChangeAdapter<>(model.getVarieties(), plantVarityListView, model.getSelectedVarietyValueWrapper()));
    }
}
