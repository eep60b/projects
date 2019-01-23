package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.adapter.EditListViewPropertyChangeAdapter;
import com.etlsolutions.javafx.presentation.dialog.log.task.EditTaskDataModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class PlantTaskPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView<Task> taskListView;
    private final Button editGventButton;
    private final Button removeGventButton;

    PlantTaskPropertyChangeAdapter(ListView<Task> taskListView, Button editGventButton, Button removeGventButton) {
        this.taskListView = taskListView;
        this.editGventButton = editGventButton;
        this.removeGventButton = removeGventButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        process((ValueWrapper<Task>) evt.getSource());
    }

    public void process(ValueWrapper<Task> wrapper) {
        boolean hasGvent = wrapper.getValue() != null;
        editGventButton.setDisable(!hasGvent);
        removeGventButton.setDisable(!hasGvent);
        if (hasGvent) {
            EditTaskDataModel gm = new EditTaskDataModel(wrapper.getValue());
            gm.addPropertyChangeListener(EditTaskDataModel.LIST_CHANGE_PROPERTY, new EditListViewPropertyChangeAdapter(taskListView));
            editGventButton.setOnAction(new EditItemEventHandler(gm));
        }
    }
}
