package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.menu.add.locationwizard.AddLocationEventHandler;
import com.etlsolutions.javafx.presentation.menu.edit.location.EditLocationEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditPlantLocationEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public EditPlantLocationEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        if (model.getLocation() == null) {

            AddLocationEventHandler eventHandler = new AddLocationEventHandler();
            eventHandler.handle(event);
            model.setLocation(eventHandler.getWizardDataModel().getLocation());
            return;
        }

        EditLocationEventHandler eventHandler = new EditLocationEventHandler(model.getLocation());
        eventHandler.handle(event);
        if (eventHandler.getDataModel().isModified()) {
            model.updateLocation();
        }
    }

}
