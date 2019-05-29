package com.etlsolutions.javafx.presentation.dialog.log.task;

import com.etlsolutions.javafx.data.log.task.Task;
import static com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel.LIST_CHANGE_PROPERTY;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class EditTaskDataModel extends AbstractTaskDataModel {

    public EditTaskDataModel(Task task) {
        super(task);
    }

    @Override
    public void save() {
       
        Task task = getItem();
        task.setCommonValues(getValueWrapper());
        task.setNotifications(getNotifications());
        task.setModifiedTime(LocalDateTime.now());
        task.setStartTime(getStartTimeValueWrapper().getValue());
        support.firePropertyChange(LIST_CHANGE_PROPERTY, true, false);        
    }
}

