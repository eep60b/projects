package com.etlsolutions.javafx.presentation.dialog.plantgroup;

import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.DataUnitFXMLController;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.adapter.ListViewListChangeAdapter;
import com.etlsolutions.javafx.presentation.RemoveEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.ValueChangeButtonPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.ValueChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.plant.plantvariety.EditVarietyDataModel;
import static com.etlsolutions.javafx.presentation.dialog.plantsubgroup.AbstractPlantSubGroupDataModel.REMOVE_VARIETY_ID;
import com.etlsolutions.javafx.presentation.dialog.plantsubgroup.CreatePlantSubGroupDataModel;
import com.etlsolutions.javafx.presentation.dialog.plantsubgroup.EditPlantSubGroupDataModel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author zc
 */
public class PlantGroupFXMLController extends DataUnitFXMLController<PlantGroup, AbstractPlantGroupDataModel> {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea informationTextArea;

    @FXML
    private Button addImageButton;

    @FXML
    private Button editImageButton;

    @FXML
    private Button removeImageButton;

    @FXML
    private Button moveToBeginImageButton;

    @FXML
    private Button moveToLeftImageButton;

    @FXML
    private Button moveToRightImageButton;

    @FXML
    private Button moveToEndImageButton;

    @FXML
    private TilePane imageTilePane;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ListView<PlantSubGroup> plantSubGroupListView;

    @FXML
    private Button addPlantSubGroupButton;

    @FXML
    private Button editPlantSubGroupButton;

    @FXML
    private Button removePlantSubGroupButton;

    @Override
    public void initializeComponents() throws IOException, Exception {

        initCommonComponents(titleTextField, informationTextArea, imageTilePane, addImageButton, editImageButton, moveToBeginImageButton, moveToLeftImageButton, moveToRightImageButton, moveToEndImageButton, removeImageButton, errorMessageLabel, okButton, cancelButton);

        removePlantSubGroupButton.setDisable(model.getSelectedPlantSubGroup().getValue() == null);
        editPlantSubGroupButton.setDisable(model.getSelectedPlantSubGroup().getValue() == null);
        plantSubGroupListView.setItems(model.getPlantSubGroups());
        plantSubGroupListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        plantSubGroupListView.getSelectionModel().select(model.getSelectedPlantSubGroup().getValue());
        plantSubGroupListView.getSelectionModel().selectedItemProperty().addListener(new ValueChangeAdapter<>(model.getSelectedPlantSubGroup()));
        addPlantSubGroupButton.setOnAction(new AddItemEventHandler<>(model.getPlantSubGroups(), model.getSelectedPlantSubGroup(), new CreatePlantSubGroupDataModel()));        
        EditPlantSubGroupDataModel vm = new EditPlantSubGroupDataModel(model.getSelectedPlantSubGroup().getValue());
        vm.addPropertyChangeListener( EditVarietyDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(plantSubGroupListView));        
        editPlantSubGroupButton.setOnAction(new EditItemEventHandler(vm));
        removePlantSubGroupButton.setOnAction(new RemoveEventHandler(model, REMOVE_VARIETY_ID));
        model.getSelectedPlantSubGroup().addPropertyChangeListener(ValueWrapper.VALUE_CHANGE, new ValueChangeButtonPropertyChangeAdapter<>(editPlantSubGroupButton, removePlantSubGroupButton));
        model.getPlantSubGroups().addListener(new ListViewListChangeAdapter<>(model.getPlantSubGroups(), plantSubGroupListView, model.getSelectedPlantSubGroup()));        
    }

}
