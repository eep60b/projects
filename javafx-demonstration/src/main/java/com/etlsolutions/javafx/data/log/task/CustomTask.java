package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class CustomTask extends Task {

    public CustomTask() {
    }

    public CustomTask(DataUnitValueWrapper valueWrapper, TaskDetailValueWrapper detailValueWrapper) {
        super(valueWrapper, detailValueWrapper);
    }

    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }  
}
