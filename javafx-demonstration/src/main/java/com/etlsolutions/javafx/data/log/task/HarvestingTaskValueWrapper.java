package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class HarvestingTaskValueWrapper extends TaskValueWrapper {

    private final ValueWrapper<String> qualityValueWrapper;
    private final ValueWrapper<String> quatantityValueWrapper;
    private final ValueWrapper<String> uomValueWrapper;

    public HarvestingTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications, String quality, double quatantity, String uom) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);

        qualityValueWrapper = new ValueWrapper<>(quality);
        quatantityValueWrapper = getWrapper(quatantity);
        uomValueWrapper = new ValueWrapper<>(uom);
    }

    public HarvestingTaskValueWrapper(HarvestingTask task) {
        super(task);
        qualityValueWrapper = new ValueWrapper<>(task.getQuality());
        quatantityValueWrapper = new ValueWrapper<>(String.valueOf(task.getQuatantity()));
        uomValueWrapper = new ValueWrapper<>(task.getUom());
    }

    public ValueWrapper<String> getQualityValueWrapper() {
        return qualityValueWrapper;
    }

    public ValueWrapper<String> getQuatantityValueWrapper() {
        return quatantityValueWrapper;
    }

    public ValueWrapper<String> getUomValueWrapper() {
        return uomValueWrapper;
    }

    @Override
    public TaskType getType() {
        return TaskType.HARVESTING;
    }

    
    public double getQuatantity() {
        
        return Double.parseDouble(quatantityValueWrapper.getValue());
    }
}
