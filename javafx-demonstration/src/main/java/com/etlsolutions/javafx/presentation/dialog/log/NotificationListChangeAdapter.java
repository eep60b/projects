package com.etlsolutions.javafx.presentation.dialog.log;

import com.etlsolutions.javafx.data.log.Notification;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class NotificationListChangeAdapter implements ListChangeListener<Notification> {

    private final Notifiable model;
    private final ListView<Notification> notificationListView;

    public NotificationListChangeAdapter(Notifiable model, ListView<Notification> notificationListView) {
        this.model = model;
        this.notificationListView = notificationListView;
    }

    @Override
    public void onChanged(Change<? extends Notification> c) {
        notificationListView.setItems(model.getNotifications());
    }

}
