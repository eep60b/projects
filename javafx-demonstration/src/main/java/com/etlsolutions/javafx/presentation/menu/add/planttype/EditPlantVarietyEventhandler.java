package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.EditVarietyDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditPlantVarietyEventhandler implements EventHandler<ActionEvent> {

    private final AddPlantTypeDataModel model;
    private final PlantVariety variety;

    public EditPlantVarietyEventhandler(AddPlantTypeDataModel model, PlantVariety variety) {
        this.model = model;
        this.variety = variety;
    }

    @Override
    public void handle(ActionEvent event) {
        
        EditVarietyDataModel varietyDataModel = new EditVarietyDataModel(variety);
        new FXMLActionEventHandler<>(varietyDataModel).handle(event);
        model.updateVariety();
    }
}
