package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.TaskDetail;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.Removable;
import com.etlsolutions.javafx.presentation.RemoveEventId;
import com.etlsolutions.javafx.presentation.Savable;

/**
 *
 * @author Zhipeng
 * @param <T>
 */
public abstract class TaskDetailDataModel <T extends TaskDetail> implements Savable, Removable {

    protected final T detail;

    public TaskDetailDataModel(T detail) {
        this.detail = detail;
    }

    public abstract String getFxmlPath();
    
    public TaskType getType() {
        return detail.getType();
    }

    public T getDetail() {
        return detail;
    }

}
