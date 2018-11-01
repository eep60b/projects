package com.etlsolutions.javafx.presentation.menu.add.gvent;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.NotificationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditGventNotificationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractGventDataModel model;

    public EditGventNotificationEventHandler(AbstractGventDataModel model) {
        
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        NotificationDataModel notificationDataModel = new NotificationDataModel(model.getSelectedNotification());        
        new FXMLActionEventHandler<>(notificationDataModel).handle(event);
    }  
}
