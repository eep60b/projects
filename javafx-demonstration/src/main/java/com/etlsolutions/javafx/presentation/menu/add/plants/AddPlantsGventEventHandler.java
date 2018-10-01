package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.AbstractActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.gvent.AddGventDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsGventEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddPlantsGventEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddGventDataModel eventModel = new AddGventDataModel();
        AbstractActionEventHandler<AddGventDataModel> handler = new AbstractActionEventHandler<>(eventModel);
        handler.handle(event);
        Gvent e = eventModel.getEvent();
        model.getEvents().add(e);
        model.setSelectedEvent(e);
    }
    
}
