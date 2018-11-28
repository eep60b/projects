package com.etlsolutions.javafx.presentation.plant.subgroup;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plant.plantvariety.EditVarietyDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author zc
 */
public class EditPlantVarietyEventhandler implements EventHandler<ActionEvent> {

    private final AbstractPlantSubGroupDataModel model;
    private final Button removePlantVarietyButton;
    private final Button editPlantVarietyButton;
    private final ListView plantVarityListView;

    public EditPlantVarietyEventhandler(AbstractPlantSubGroupDataModel model, Button removePlantVarietyButton, Button editPlantVarietyButton, ListView plantVarityListView) {
        this.model = model;
        this.removePlantVarietyButton = removePlantVarietyButton;
        this.editPlantVarietyButton = editPlantVarietyButton;
        this.plantVarityListView = plantVarityListView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        EditVarietyDataModel varietyDataModel = new EditVarietyDataModel(model.getSelectedVarietyValueWrapper().getValue());
        new FXMLActionEventHandler<>(varietyDataModel).handle(event);
          removePlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        editPlantVarietyButton.setDisable(model.getSelectedVarietyValueWrapper() == null);
        plantVarityListView.setItems(model.getVarieties());
    }
}
