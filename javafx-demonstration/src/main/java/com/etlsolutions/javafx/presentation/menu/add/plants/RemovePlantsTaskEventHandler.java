package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantsTaskEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public RemovePlantsTaskEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedTask();
    }
    
}
