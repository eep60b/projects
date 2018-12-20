package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.log.growingobservation.AddGrowingObservationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddObservationForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddObservationForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getGrowingObservations(), model.getSelectedGrowingObservationValueWrapper(), new AddGrowingObservationDataModel()).handle(event);
    }
    
}
