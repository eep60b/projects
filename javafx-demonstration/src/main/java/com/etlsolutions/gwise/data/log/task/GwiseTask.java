package com.etlsolutions.gwise.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.GwiseLog;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.javafx.data.log.task.TaskType;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zc
 */

public abstract class GwiseTask extends GwiseLog {

    private final ObservableListWrapperA<Notification> notifications;

    public GwiseTask(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocalDateTime createdTime, LocalDateTime modifiedTime, LocalDateTime startTime, List<Notification> notifications) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, createdTime, modifiedTime, startTime);
        this.notifications = new ObservableListWrapperA<>(notifications);
    }

    public GwiseTask(GwiseTaskBean bean) {
        super(bean);
        notifications = new ObservableListWrapperA<>(bean.getNotifications());
    }

    public abstract TaskType getType();

    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }
}
