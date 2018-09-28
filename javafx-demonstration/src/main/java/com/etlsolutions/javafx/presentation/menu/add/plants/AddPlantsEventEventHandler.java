package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.menu.add.event.AddEventDataModel;
import com.etlsolutions.javafx.presentation.menu.add.event.AddEventEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsEventEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddPlantsEventEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddEventDataModel eventModel = new AddEventDataModel();
        AddEventEventHandler handler = new AddEventEventHandler(eventModel);
        handler.handle(event);
        Gvent e = eventModel.getEvent();
        model.getEvents().add(e);
        model.setSelectedEvent(e);
    }
    
}
