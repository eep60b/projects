package com.etlsolutions.javafx.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import com.etlsolutions.javafx.presentation.Savable;

/**
 *
 * @author zc
 */
public class SaveEventHandler implements EventHandler<ActionEvent> {

    private final Savable model;

    public SaveEventHandler(Savable model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.save();
    }
    
}
