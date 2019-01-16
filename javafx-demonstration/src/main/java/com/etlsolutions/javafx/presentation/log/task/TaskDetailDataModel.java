package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.log.task.TaskValueWrapper;
import com.etlsolutions.javafx.data.log.task.TaskType;
import com.etlsolutions.javafx.presentation.FXMLActionDataModel;
import com.etlsolutions.javafx.presentation.Removable;
import com.etlsolutions.javafx.presentation.Savable;

/**
 *
 * @author Zhipeng
 * @param <T>
 */
public abstract class TaskDetailDataModel <T extends TaskValueWrapper> implements Savable, Removable, FXMLActionDataModel {

    protected final T detail;

    public TaskDetailDataModel(T detail) {
        this.detail = detail;
    }

    @Override
    public abstract String getFxmlPath();
    
    public TaskType getType() {
        return detail.getType();
    }

    public T getDetail() {
        return detail;
    }

}
