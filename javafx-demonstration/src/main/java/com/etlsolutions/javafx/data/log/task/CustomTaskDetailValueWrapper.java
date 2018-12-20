package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class CustomTaskDetailValueWrapper extends TaskDetailValueWrapper {

    public CustomTaskDetailValueWrapper() {        
    }

    public CustomTaskDetailValueWrapper(CustomTask task) {
        super(task);
    }
    
    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }
}
