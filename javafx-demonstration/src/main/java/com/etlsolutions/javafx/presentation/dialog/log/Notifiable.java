package com.etlsolutions.javafx.presentation.dialog.log;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.log.Notification;

/**
 *
 * @author zc
 */
public interface Notifiable {

    ObservableListWrapperA<Notification> getNotifications();

    public ValueWrapper<Notification> getSelectedNotification();
}
