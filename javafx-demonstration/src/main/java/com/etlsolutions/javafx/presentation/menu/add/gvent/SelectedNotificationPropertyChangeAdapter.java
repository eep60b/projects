package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.Notification;
import com.etlsolutions.javafx.presentation.log.Notifiable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class SelectedNotificationPropertyChangeAdapter implements PropertyChangeListener {

    private final Notifiable model;
    private final ListView<Notification> notificationListView;
    private final Button editNotificationButton;
    private final Button removeNotificationButton;

    public SelectedNotificationPropertyChangeAdapter(Notifiable model, ListView<Notification> notificationListView, Button editNotificationButton, Button removeNotificationButton) {
        this.model = model;
        this.notificationListView = notificationListView;
        this.editNotificationButton = editNotificationButton;
        this.removeNotificationButton = removeNotificationButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
 
        Notification n = model.getSelectedNotification().getValue();
        notificationListView.getSelectionModel().select(n);
        editNotificationButton.setDisable(n == null);
        removeNotificationButton.setDisable(n == null);
    }

}
