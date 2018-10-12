package com.etlsolutions.javafx.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import com.etlsolutions.javafx.presentation.Addable;

/**
 *
 * @author zc
 */
public class SaveEventHandler implements EventHandler<ActionEvent> {

    private final Addable model;

    public SaveEventHandler(Addable model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.add();
    }
    
}
