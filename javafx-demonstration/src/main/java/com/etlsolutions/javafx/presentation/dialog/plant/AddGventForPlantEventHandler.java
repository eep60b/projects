package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.gvent.AddGventDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddGventForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddGventForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getGvents(), model.getSelectedGventValueWrapper(), new AddGventDataModel()).handle(event);
    }
    
}
