package com.etlsolutions.javafx.presentation.plant;

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

    private final AddPlantDataModel model;

    public AddPlantsGventEventHandler(AddPlantDataModel model) {
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
