package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.presentation.Savable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
