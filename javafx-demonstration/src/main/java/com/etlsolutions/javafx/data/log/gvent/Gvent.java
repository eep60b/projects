package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class Gvent extends Log {

    private ObservableList<Notification> notifications;
    private LocalDateTime endTime;

    public Gvent() {
    }

    public abstract GventType getType();

    public Gvent(ObservableList<Notification> notifications, LocalDateTime endTime, DataUnitValueWrapper valueWrapper, LocalDateTime startTime) {
        super(valueWrapper, startTime);
        this.notifications = notifications;
        this.endTime = endTime;
    }

    public ObservableList<Notification> getNotifications() {
        return notifications;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
