package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.gvent.Gvent;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
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
        FXMLActionEventHandler<AddGventDataModel> handler = new FXMLActionEventHandler<>(eventModel);
        handler.handle(event);
        Gvent e = eventModel.get();
        model.getGvents().add(e);
        model.getSelectedEventValueWrapper().setValue(e);
    }
    
}
