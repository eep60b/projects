package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.AddAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddAreaEventHandler implements EventHandler<ActionEvent> {

    public AddAreaEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddAreaDataModel()).handle(event);
    }
    
}
