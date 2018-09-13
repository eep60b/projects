package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.presentation.Savable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public class SaveExitEventHandler implements EventHandler<ActionEvent> {

    private final Savable model;
    private final Stage parentStage;

    public SaveExitEventHandler(Savable model, Stage parentStage) {
        this.model = model;
        this.parentStage = parentStage;
    }

    @Override
    public void handle(ActionEvent event) {
        model.save();
        parentStage.close();
    }
}
