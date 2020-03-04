package com.etlsolutions.javafx.data.log.task;

import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class CustomTaskValueWrapper extends TaskValueWrapper {

    public CustomTaskValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, ObservableListWrapperA<Notification> notifications) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, notifications);
    }

    public CustomTaskValueWrapper(CustomTask task) {
        super(task);
    }
    
    @Override
    public TaskType getType() {
        return TaskType.CUSTOM;
    }
}
