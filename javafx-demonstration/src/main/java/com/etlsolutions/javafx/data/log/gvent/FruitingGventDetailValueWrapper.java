package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.DoubleValueWrapper;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class FruitingGventDetailValueWrapper extends DoubleValueWrapper implements GventDetailValueWrapper {

    private final ValueWrapper<LocalDateTime> startTimeValueWrapper;
    private final ValueWrapper<LocalDateTime> endTimeValueWrapper;
    private final ValueWrapper<Boolean> countableValueWrapper;
    private final ValueWrapper<Integer> countValueWrapper;
    private final ValueWrapper<String> colorValueWrapper;
    private final ValueWrapper<String> shapeValueWrapper;
    private final ValueWrapper<String> averageSizeValueWrapper;
    private final ValueWrapper<String> averageWeightValueWrapper;
    private final ObservableListWrapperA<Notification> notifications;

    public FruitingGventDetailValueWrapper() {
        startTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        endTimeValueWrapper = new ValueWrapper<>(LocalDateTime.now());
        this.countableValueWrapper = new ValueWrapper<>(true);
        this.countValueWrapper = new ValueWrapper<>(1);
        this.colorValueWrapper = new ValueWrapper<>("red");
        this.shapeValueWrapper = new ValueWrapper<>("round");
        this.averageSizeValueWrapper = getWrapper(0);
        this.averageWeightValueWrapper = getWrapper(0);
        notifications = new ObservableListWrapperA<>();
    }

    public FruitingGventDetailValueWrapper(FruitingGvent gvent) {
        startTimeValueWrapper = new ValueWrapper<>(gvent.getStartTime());
        endTimeValueWrapper = new ValueWrapper<>(gvent.getEndTime());
        countableValueWrapper = new ValueWrapper<>(gvent.getNumberPerPlant() >= 0);
        countValueWrapper = new ValueWrapper<>(gvent.getNumberPerPlant());
        colorValueWrapper = new ValueWrapper<>(gvent.getColor());
        shapeValueWrapper = new ValueWrapper<>(gvent.getShape());
        averageSizeValueWrapper = getWrapper(gvent.getAverageSize());
        averageWeightValueWrapper = getWrapper(gvent.getAverageWeight());
        notifications = new ObservableListWrapperA<>(gvent.getNotifications());
    }

    @Override
    public ValueWrapper<LocalDateTime> getStartTimeValueWrapper() {
        return startTimeValueWrapper;
    }

    @Override
    public ValueWrapper<LocalDateTime> getEndTimeValueWrapper() {
        return endTimeValueWrapper;
    }

    public ValueWrapper<Boolean> getCountableValueWrapper() {
        return countableValueWrapper;
    }

    public ValueWrapper<Integer> getCountValueWrapper() {
        return countValueWrapper;
    }

    public ValueWrapper<String> getColorValueWrapper() {
        return colorValueWrapper;
    }

    public ValueWrapper<String> getShapeValueWrapper() {
        return shapeValueWrapper;
    }

    public ValueWrapper<String> getAverageSizeValueWrapper() {
        return averageSizeValueWrapper;
    }

    public ValueWrapper<String> getAverageWeightValueWrapper() {
        return averageWeightValueWrapper;
    }

    public double getAverageSize() {
        return getValue(averageSizeValueWrapper);
    }

    public double getAverageWeight() {
        return getValue(averageWeightValueWrapper);
    }

    @Override
    public ObservableListWrapperA<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public GventType getType() {
        return GventType.FRUITING;
    }
}
