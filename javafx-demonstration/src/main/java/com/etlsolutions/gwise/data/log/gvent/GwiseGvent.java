package com.etlsolutions.gwise.data.log.gvent;

import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.GwiseLog;
import com.etlsolutions.gwise.data.log.Notification;
import com.etlsolutions.gwise.data.ImageLink;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zc
 */
public abstract class GwiseGvent extends GwiseLog {

    private final ObservableListWrapperA<Notification> notifications;
    private final ValueWrapper<LocalDateTime> endTimeWrapper;

    public GwiseGvent(int id, String title, String information, List<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath, LocalDateTime createdTime, LocalDateTime modifiedTime, LocalDateTime startTime,
            List<Notification> notifications, LocalDateTime endTime) {
        super(id, title, information, imageLinks, selectedImgLinkIndex, logoPath, createdTime, modifiedTime, startTime);
        this.notifications = new ObservableListWrapperA<>(notifications);
        endTimeWrapper = new ValueWrapper<>(endTime);
    }

    public GwiseGvent(GwiseGventBean bean) {
        super(bean);
        notifications = new ObservableListWrapperA<>(bean.getNotifications());
        endTimeWrapper = new ValueWrapper<>(bean.getEndTime());
    }

    public abstract GventType getType();
    
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    public LocalDateTime getEndTime() {
        return endTimeWrapper.getValue();
    }

    public void setEndTime(LocalDateTime endTime) {
        endTimeWrapper.setValue(endTime);
    }

    public ValueWrapper<LocalDateTime> getEndTimeWrapper() {
        return endTimeWrapper;
    }
}
