package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class CustomGventDetailValueWrapper implements GventDetailValueWrapper {

    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;
    private final ObservableListWrapperA<Notification> notifications;
    
    public CustomGventDetailValueWrapper() {

        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        endTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        notifications = new ObservableListWrapperA<>();
    }
    
    public CustomGventDetailValueWrapper(FloweringGvent floweringGvent) {
        startTimeValueWrapper = new ValueWrapper<>(floweringGvent.getStartTime());
        endTimeValueWrapper = new ValueWrapper<>(floweringGvent.getEndTime());
        notifications = new ObservableListWrapperA<>(floweringGvent.getNotifications());
    }

    @Override
    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    @Override
    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }
}
