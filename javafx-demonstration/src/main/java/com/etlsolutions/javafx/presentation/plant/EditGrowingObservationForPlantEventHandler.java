package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.log.growingobservation.EditGrowingObservationDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditGrowingObservationForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public EditGrowingObservationForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditGrowingObservationDataModel(model.getSelectedGrowingObservationValueWrapper().getValue())).handle(event);
    }
    
}
