package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.task.AddTaskDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddTaskForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddTaskForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getTasks(), model.getSelectedTaskValueWrapper(), new AddTaskDataModel()).handle(event);
    }
    
}
