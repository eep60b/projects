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
        set(LogFactory.getInstance().createTask(commonValueWrapper, selectedType.getValue(), notifications, detailDataModel.getDetail()));
        ProjectManager.getInstance().getContents().getLogGroupRoot().getTasks().addLog(get());
        detailDataModel.save();
    }
    
}
