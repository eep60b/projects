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
    private final Closable[] closables;

    public CancelEventHandler(Stage parentStage, Closable... closables) {
        this.parentStage = parentStage;
        this.closables = closables;
    }

    @Override
    public void handle(ActionEvent event) {
        parentStage.close();
        for(Closable closable : closables) {
            closable.close();
        }
    } 
}
