package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.log.GwiseLogBean;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class GwiseGventBean extends GwiseLogBean {

    private List<Notification> notifications = new ArrayList<>();
    private LocalDateTime endTime = LocalDateTime.now();

    public GwiseGventBean() {

    }

    public GwiseGventBean(GwiseGvent gvent) {
        super(gvent);
        notifications = new ArrayList<>(gvent.getNotifications());
        endTime = gvent.getEndTime();
    }

    public abstract GventType getType();

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
