package com.etlsolutions.javafx.presentation.dialog.log;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.log.Notifiable;
import com.etlsolutions.javafx.presentation.dialog.log.NotificationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddNotificationEventHandler implements EventHandler<ActionEvent> {

    private final Notifiable model;

    public AddNotificationEventHandler(Notifiable model) {
        
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        NotificationDataModel notificationDataModel = new NotificationDataModel();        
        new FXMLActionEventHandler<>(notificationDataModel).handle(event);
        if(notificationDataModel.isSaved()) {
            model.getNotifications().add(notificationDataModel.getNotification());
        }
    }  
}
