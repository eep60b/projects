package com.etlsolutions.javafx.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class SaveExitEventHandler implements EventHandler<ActionEvent> {

    private final Addable model;
    private final Stage parentStage;

    public SaveExitEventHandler(Addable model, Stage parentStage) {
        this.model = model;
        this.parentStage = parentStage;
    }

    @Override
    public void handle(ActionEvent event) {
        model.add();
        parentStage.close();
    }
}
