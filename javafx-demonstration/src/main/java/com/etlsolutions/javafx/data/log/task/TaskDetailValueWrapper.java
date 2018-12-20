package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class TaskDetailValueWrapper {
    
    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ObservableListWrapperA<Notification> notifications;

    public TaskDetailValueWrapper() {
        this.startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        notifications = new ObservableListWrapperA<>();
    }

    public TaskDetailValueWrapper(Task task) {
        this.startTimeValueWrapper = new ValueWrapper<>(task.getStartTime());
        notifications = new ObservableListWrapperA<>(task.getNotifications());
    }
    
    public abstract TaskType getType();

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }
    
    public LocalDateTime getStartTime() {
        return startTimeValueWrapper.getValue();
    }
    
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }
}
