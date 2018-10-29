package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemoveAliasEventHandler implements EventHandler<ActionEvent> {

    private final AbstractVarietyDataModel model;

    public RemoveAliasEventHandler(AbstractVarietyDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedAlias();
    }    
}
