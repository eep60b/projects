package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.plant.AddPlantDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantsEventHandler implements EventHandler<ActionEvent> {

    public AddPlantsEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddPlantDataModel()).handle(event);
    }
    
}
