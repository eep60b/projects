package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.data.log.task.Task;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddTaskDataModel extends AbstractTaskDataModel {

    @Override
    public void save() {
        Task task = LogFactory.getInstance().createTask(getValueWrapper, detailDataModel.getDetail());
        set(task);
        ProjectManager.getInstance().getContents().getLogGroupRoot().getTasks().addLog(task);
        ProjectManager.getInstance().addItem(task);
        detailDataModel.save();
    }
    
}
