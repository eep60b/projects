package com.etlsolutions.javafx.data.log.task;

/**
 *
 * @author zc
 */
public class CustomTask extends Task {

    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }
  
}
