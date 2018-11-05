package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.LogFactory;
import com.etlsolutions.javafx.system.ProjectManager;

/**
 *
 * @author zc
 */
public class AddTaskDataModel extends AbstractTaskDataModel {

    @Override
    public void save() {
        task = LogFactory.getInstance().createTask(title, information, imageLinks, logoPath, 
                selectedType.getValue(), notifications, detailDataModel.getDetail());
        ProjectManager.getInstance().getProject().getLogGroupRoot().getTasks().addLog(task);
        detailDataModel.save();
    }
    
}
