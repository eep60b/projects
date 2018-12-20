package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.growingmedium.AddGrowingMediumDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddGrowingMediumForPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddGrowingMediumForPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getGrowingMediums(), model.getGrowingMediumValueWrapper(), new AddGrowingMediumDataModel()).handle(event);
    }
    
}
