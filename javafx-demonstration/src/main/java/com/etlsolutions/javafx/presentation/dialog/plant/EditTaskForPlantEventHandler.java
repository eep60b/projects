package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.task.EditTaskDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditTaskForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public EditTaskForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditTaskDataModel(model.getSelectedTaskValueWrapper().getValue())).handle(event);
    }
    
}
