package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class FloweringGventDetailValueWrapper implements GventDetailValueWrapper {

    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;
    private final ValueWrapper<String> flowerTypeValueWrapper;    
    private final ValueWrapper<Integer> numberPerPlantValueWrapper;
    private final ValueWrapper<String> colorValueWrapper;
    private final ObservableListWrapperA<Notification> notifications;

    public FloweringGventDetailValueWrapper() {
        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        endTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        flowerTypeValueWrapper = new ValueWrapper<>("");
        numberPerPlantValueWrapper =  new ValueWrapper<>(0);
        colorValueWrapper =  new ValueWrapper<>("");
        notifications = new ObservableListWrapperA<>();
    }

    public FloweringGventDetailValueWrapper(FloweringGvent floweringGvent) {
        startTimeValueWrapper = new ValueWrapper<>(floweringGvent.getStartTime());
        endTimeValueWrapper = new ValueWrapper<>(floweringGvent.getEndTime());
        flowerTypeValueWrapper = new ValueWrapper<>(floweringGvent.getFlowerType());
        numberPerPlantValueWrapper =  new ValueWrapper<>(floweringGvent.getCount());
        colorValueWrapper =  new ValueWrapper<>(floweringGvent.getColor());
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
    
    public ValueWrapper<String> getFlowerTypeValueWrapper() {
        return flowerTypeValueWrapper;
    }

    public ValueWrapper<Integer> getNumberPerPlantValueWrapper() {
        return numberPerPlantValueWrapper;
    }

    public ValueWrapper<String> getColorValueWrapper() {
        return colorValueWrapper;
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }
}
