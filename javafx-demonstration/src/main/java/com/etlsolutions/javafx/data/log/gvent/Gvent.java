package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.Notification;
import java.time.LocalDateTime;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public abstract class Gvent extends Log {

    private ObservableList<Notification> notifications;
    private LocalDateTime endTime;

    public Gvent() {
    }

    public abstract GventType getType();

    public Gvent(LocalDateTime endTime, LocalDateTime modifiedTime, LocalDateTime startTime, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(modifiedTime, startTime, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        notifications = new ObservableListWrapperA<>();
        this.endTime = endTime;
    }

    public Gvent(LocalDateTime endTime, LocalDateTime modifiedTime, LocalDateTime startTime, int id, String title, String information, ObservableListWrapperA<ImageLink> imageLinks, int selectedImgLinkIndex, String logoPath) {
        super(modifiedTime, startTime, id, title, information, imageLinks, selectedImgLinkIndex, logoPath);
        notifications = new ObservableListWrapperA<>();
        this.endTime = endTime;
    }



    public ObservableList<Notification> getNotifications() {
        return notifications;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
