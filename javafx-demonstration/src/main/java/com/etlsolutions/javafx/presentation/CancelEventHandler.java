package com.etlsolutions.javafx.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class CancelEventHandler implements EventHandler<ActionEvent> {

    private final Stage parentStage;

    public CancelEventHandler(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void handle(ActionEvent event) {
        parentStage.close();
    }
    
}
