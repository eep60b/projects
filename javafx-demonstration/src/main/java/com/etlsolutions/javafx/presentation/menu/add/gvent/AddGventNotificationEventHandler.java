package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.NotificationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddGventNotificationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractGventDataModel model;

    public AddGventNotificationEventHandler(AbstractGventDataModel model) {
        
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
