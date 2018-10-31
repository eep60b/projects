package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class CustomTaskDetail implements TaskDetail {

    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }
    
}
