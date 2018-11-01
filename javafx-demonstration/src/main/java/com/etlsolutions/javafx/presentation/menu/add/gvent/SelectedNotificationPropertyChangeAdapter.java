package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.Notification;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author zc
 */
public class SelectedNotificationPropertyChangeAdapter implements PropertyChangeListener {

    private final ListView<Notification> notificationListView;
    private final Button editNotificationButton;
    private final Button removeNotificationButton;

    public SelectedNotificationPropertyChangeAdapter(ListView<Notification> notificationListView, Button editNotificationButton, Button removeNotificationButton) {
        this.notificationListView = notificationListView;
        this.editNotificationButton = editNotificationButton;
        this.removeNotificationButton = removeNotificationButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AbstractGventDataModel model = (AbstractGventDataModel) evt.getSource();
        Notification n = model.getSelectedNotification();
        notificationListView.getSelectionModel().select(n);
        editNotificationButton.setDisable(n == null);
        removeNotificationButton.setDisable(n == null);
    }

}
