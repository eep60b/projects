package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.data.log.Notification;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class SelectedNotificationChangeAdapter implements ChangeListener<Notification> {

    private final AbstractGventDataModel model;

    public SelectedNotificationChangeAdapter(AbstractGventDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Notification> observable, Notification oldValue, Notification newValue) {
        model.setSelectedNotification(newValue);
    }
}
