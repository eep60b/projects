package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.gwise.data.log.gvent.GventType;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class FloweringGventValueWrapper extends GventDetailValueWrapper {

    private final ValueWrapper<String> colorValueWrapper;
    private final ValueWrapper<String> flowerTypeValueWrapper;    
    private final ValueWrapper<Integer> numberPerPlantValueWrapper;    

    public FloweringGventValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime, ObservableListWrapperA<Notification> notifications, String color, String flowerType, int numberPerPlant) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, endTime, notifications);
        colorValueWrapper = new ValueWrapper<>(color);
        flowerTypeValueWrapper = new ValueWrapper<>(flowerType);
        numberPerPlantValueWrapper = new ValueWrapper<>(numberPerPlant);
    }

    public FloweringGventValueWrapper(FloweringGvent gvent) {
        super(gvent);
        this.colorValueWrapper = new ValueWrapper<>(gvent.getColor());
        flowerTypeValueWrapper = new ValueWrapper<>(gvent.getFlowerType());
        numberPerPlantValueWrapper = new ValueWrapper<>(gvent.getCount());
    }

    public ValueWrapper<String> getColorValueWrapper() {
        return colorValueWrapper;
    }

    public ValueWrapper<String> getFlowerTypeValueWrapper() {
        return flowerTypeValueWrapper;
    }

    public ValueWrapper<Integer> getNumberPerPlantValueWrapper() {
        return numberPerPlantValueWrapper;
    }

    @Override
    public GventType getType() {
        return GventType.FLOWERING;
    }
}
