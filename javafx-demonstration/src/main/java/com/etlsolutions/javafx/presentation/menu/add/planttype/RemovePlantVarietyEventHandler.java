package com.etlsolutions.javafx.presentation.menu.add.planttype;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantVarietyEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantTypeDialogDataModel model;

    public RemovePlantVarietyEventHandler(AddPlantTypeDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedPlantVariety();
    }
    
}
