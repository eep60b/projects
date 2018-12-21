package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;

/**
 *
 * @author zc
 */
public class CustomTask extends Task {

    public CustomTask() {
    }

    public CustomTask(DataUnitValueWrapper valueWrapper, CustomTaskDetailValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
    }

    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }  
}
