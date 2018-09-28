package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.task.Task;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class TaskSelectionChangeAdapter implements ChangeListener<SelectionModel<Task>> {

    private final AddPlantsDataModel model;

    public TaskSelectionChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<Task>> observable, SelectionModel<Task> oldValue, SelectionModel<Task> newValue) {
        model.setSelectedTask(newValue.getSelectedItem());
    }
    
}
