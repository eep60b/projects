package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.location.AddLocationDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.location.EditLocationDataModel;
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

            AddLocationDataModel addLocationDataModel = new AddLocationDataModel();
            FXMLActionEventHandler<AddLocationDataModel> eventHandler = new FXMLActionEventHandler<>(addLocationDataModel); 
            eventHandler.handle(event);
            model.setLocation(addLocationDataModel.getLocation());
            return;
        }

        EditLocationDataModel editLocationDataModel = new EditLocationDataModel(area, subArea, location);
        EditLocationEventHandler eventHandler = new EditLocationEventHandler(model.getLocation());
        eventHandler.handle(event);
        if (eventHandler.getDataModel().isModified()) {
            model.updateLocation();
        }
    }

}
