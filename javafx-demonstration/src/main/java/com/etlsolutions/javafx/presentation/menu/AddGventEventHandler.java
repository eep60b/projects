package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.log.gvent.AddGventDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddGventEventHandler implements EventHandler<ActionEvent> {

    public AddGventEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddGventDataModel()).handle(event);
    }
    
}
