package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.other.GrowingMedium;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.growingmedium.AddGrowingMediumDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * AddPlantsGrowingMediumEventHandler is a delegation class which pass the event
 * to AddGrowingMediumDataModel to add a growing medium. This class will not add
 * the item directly. Once the growing medium is created and added to the global
 * list. The class set the selection.
 *
 * @author zc
 */
public class AddPlantsGrowingMediumEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddPlantsGrowingMediumEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddGrowingMediumDataModel growingMediumDataModel = new AddGrowingMediumDataModel();

        FXMLActionEventHandler<AddGrowingMediumDataModel> handler = new FXMLActionEventHandler<>(growingMediumDataModel);
        handler.handle(event);
        GrowingMedium g = growingMediumDataModel.getGrowingMedium();
        model.setSelectedGrowingMedium(g);
    }

}
