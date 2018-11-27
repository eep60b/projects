package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.FirstDateComparator;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.presentation.menu.edit.task.EditTaskDataModel;
import com.etlsolutions.javafx.presentation.menu.edit.task.EditTaskEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class EditPlantsTaskEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;
    private final ListView<Task> listView;

    public EditPlantsTaskEventHandler(AddPlantsDataModel model, ListView<Task> listView) {
        this.model = model;
        this.listView = listView;
    }

    @Override
    public void handle(ActionEvent event) {
        
        Task task = model.getSelectedTaskValueWrapper().getValue();
        EditTaskDataModel m = new EditTaskDataModel(task);        
        EditTaskEventHandler handler = new EditTaskEventHandler(m);
        handler.handle(event);
        listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), task);
        listView.getItems().sort(new FirstDateComparator<Task>());
    }
    
}