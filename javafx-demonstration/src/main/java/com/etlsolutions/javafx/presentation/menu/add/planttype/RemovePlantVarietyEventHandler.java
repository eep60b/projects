package com.etlsolutions.javafx.presentation.menu.add.planttype;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantVarietyEventHandler implements EventHandler<ActionEvent> {

    private final PlantTypeDialogDataModel model;

    public RemovePlantVarietyEventHandler(PlantTypeDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedPlantVariety();
    }
    
}
