package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class FruitingGventValueWrapper extends GventDetailValueWrapper {

    private final ValueWrapper<Boolean> countableValueWrapper;
    private final ValueWrapper<Integer> countValueWrapper;
    private final ValueWrapper<String> colorValueWrapper;
    private final ValueWrapper<String> shapeValueWrapper;
    private final ValueWrapper<String> averageSizeValueWrapper;
    private final ValueWrapper<String> averageLengThValueWrapper;
    private final ValueWrapper<String> averageWeightValueWrapper;

    public FruitingGventValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime, ObservableListWrapperA<Notification> notifications, boolean countable, int count, String color, String shape, double averageSize, double averageLength, double averageWeight) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, endTime, notifications);
        countableValueWrapper = new ValueWrapper<>(countable);
        countValueWrapper = new ValueWrapper<>(count);
        colorValueWrapper = new ValueWrapper<>(color);
        shapeValueWrapper = new ValueWrapper<>(shape);
        averageSizeValueWrapper = getWrapper(averageSize);
        averageLengThValueWrapper = getWrapper(averageLength);
        averageWeightValueWrapper = getWrapper(averageWeight);
    }

    public FruitingGventValueWrapper(FruitingGvent gvent) {
        super(gvent);
        countableValueWrapper = new ValueWrapper<>(gvent.getNumberPerPlant() >= 0);
        countValueWrapper = new ValueWrapper<>(gvent.getNumberPerPlant());
        colorValueWrapper = new ValueWrapper<>(gvent.getColor());
        shapeValueWrapper = new ValueWrapper<>(gvent.getShape());
        averageSizeValueWrapper = getWrapper(gvent.getAverageSize());
        averageLengThValueWrapper = getWrapper(gvent.getAverageSize());        
        averageWeightValueWrapper = getWrapper(gvent.getAverageWeight());
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
    public GventType getType() {
        return GventType.FRUITING;
    }

    double getAverageLength() {
        return getValue(averageLengThValueWrapper);
    }
}
