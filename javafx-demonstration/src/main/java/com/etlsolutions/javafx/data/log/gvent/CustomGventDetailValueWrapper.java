package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.gwise.data.log.gvent.GventType;
import com.etlsolutions.gwise.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.log.Notification;
import java.time.LocalDateTime;

/**
 *
 * @author zc
 */
public class CustomGventDetailValueWrapper extends GventDetailValueWrapper {

    public CustomGventDetailValueWrapper(String title, String information, ObservableListWrapperA<ImageLink> imageLinks, ImageLink selectedImgLinkIndex, String logoPath, LocalDateTime startTime, LocalDateTime endTime, ObservableListWrapperA<Notification> notifications) {
        super(title, information, imageLinks, selectedImgLinkIndex, logoPath, startTime, endTime, notifications);
    }

    public CustomGventDetailValueWrapper(CustomGvent gvent) {
        super(gvent);
    }

    @Override
    public GventType getType() {
        return GventType.CUSTOM;
    }

}
