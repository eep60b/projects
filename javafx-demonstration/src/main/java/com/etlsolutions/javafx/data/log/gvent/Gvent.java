package com.etlsolutions.javafx.data.log.gvent;

import com.etlsolutions.javafx.data.log.Log;
import com.etlsolutions.javafx.data.log.Notification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author zc
 */
public class Gvent extends Log {

    private ObservableList<Notification> notifications;

    public Gvent() {
    }

    public Gvent(String title, String information) {
        super(title, information);
        notifications = FXCollections.observableArrayList();
    }

    public ObservableList<Notification> getNotifications() {
        return notifications;
    }
}
