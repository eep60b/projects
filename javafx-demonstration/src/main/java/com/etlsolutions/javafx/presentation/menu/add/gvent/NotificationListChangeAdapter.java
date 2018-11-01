package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.Notification;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class NotificationListChangeAdapter implements ListChangeListener<Notification> {

    private final AbstractGventDataModel model;
    private final ListView<Notification> notificationListView;

    public NotificationListChangeAdapter(AbstractGventDataModel model, ListView<Notification> notificationListView) {
        this.model = model;
        this.notificationListView = notificationListView;
    }

    @Override
    public void onChanged(Change<? extends Notification> c) {
        notificationListView.setItems(model.getNotifications());
    }

}
