package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemovePlantsObservationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public RemovePlantsObservationEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedGrowingObservation();
    }
}
