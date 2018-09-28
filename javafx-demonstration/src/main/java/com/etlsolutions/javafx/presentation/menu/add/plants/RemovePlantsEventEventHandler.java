package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantsEventEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public RemovePlantsEventEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedEvent();
    }
    
}
