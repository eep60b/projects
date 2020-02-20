package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class TaskValueWrapper extends DataUnitValueWrapper {

    private final ValueWrapper<LocalDateTime> startTimeValueWrapper; 
    private final ObservableListWrapperA<Notification> notifications;

    public TaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        startTimeValueWrapper = new ValueWrapper<>(startTime);
        this.notifications = new ObservableListWrapperA<>(notifications);
    }

    public TaskValueWrapper(Task task) {
        super(task);
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
