package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.menu.add.growingobservation.AddGrowingObservationDataModel;
import com.etlsolutions.javafx.data.log.GrowingObservation;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsObservationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddPlantsObservationEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddGrowingObservationDataModel observationModel = new AddGrowingObservationDataModel();
        FXMLActionEventHandler<AddGrowingObservationDataModel> handler = new FXMLActionEventHandler<>(observationModel);
        handler.handle(event);
        GrowingObservation observation = observationModel.get();
        model.getGrowingObservations().add(observation);
        model.getSelectedGrowingObservationValueWrapper().setValue(observation);
    }
}
