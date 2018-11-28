package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.log.task.AddTaskDataModel;
import com.etlsolutions.javafx.data.log.task.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsTaskEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddPlantsTaskEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddTaskDataModel taskModel = new AddTaskDataModel();
//        AddTaskEventHandler handler = new AddTaskEventHandler(taskModel);
//        handler.handle(event);
        Task issue = taskModel.get();
        model.getTasks().add(issue);
        model.getSelectedTaskValueWrapper().setValue(issue);
    }
}
