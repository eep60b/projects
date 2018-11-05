package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.Notification;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class Task extends Log {

    private List<Notification> notifications;
    
    public abstract TaskType getType();

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
