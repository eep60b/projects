package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.growingmedium.AddGrowingMediumDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddGrowingMediumEventHandler implements EventHandler<ActionEvent> {

    public AddGrowingMediumEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddGrowingMediumDataModel()).handle(event);
    }
    
}
