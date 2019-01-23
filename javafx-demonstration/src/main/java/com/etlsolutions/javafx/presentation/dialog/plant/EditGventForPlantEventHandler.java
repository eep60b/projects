package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.EditGventDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditGventForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public EditGventForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditGventDataModel(model.getSelectedGventValueWrapper().getValue())).handle(event);
    }
    
}
