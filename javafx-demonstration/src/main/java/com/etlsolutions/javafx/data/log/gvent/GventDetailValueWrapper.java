package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.DataUnitValueWrapper;
import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public abstract class GventDetailValueWrapper extends DataUnitValueWrapper {
   
    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;    
    private final ObservableListWrapperA<Notification> notifications;    

    public GventDetailValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime, ObservableListWrapperA<Notification> notifications) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath);
        startTimeValueWrapper = new ValueWrapper<>(startTime);
        endTimeValueWrapper = new ValueWrapper<>(endTime);
        this.notifications = new ObservableListWrapperA<>(notifications);
    }

    public GventDetailValueWrapper(Gvent gvent) {
        super(gvent);
        startTimeValueWrapper = new ValueWrapper<>(gvent.getStartTime());
        endTimeValueWrapper = new ValueWrapper<>(gvent.getEndTime());
        notifications = new ObservableListWrapperA<>(gvent.getNotifications());
    }
    
    
    
    public abstract GventType getType();

    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }
    
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }
}
