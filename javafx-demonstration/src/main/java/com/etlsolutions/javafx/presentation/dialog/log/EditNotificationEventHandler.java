package com.etlsolutions.javafx.presentation.dialog.log;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditNotificationEventHandler implements EventHandler<ActionEvent> {

    private final Notifiable model;

    public EditNotificationEventHandler(Notifiable model) {
        
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        NotificationDataModel notificationDataModel = new NotificationDataModel(model.getSelectedNotification().getValue());        
        new FXMLActionEventHandler<>(notificationDataModel).handle(event);
    }  
}
