package com.etlsolutions.javafx.presentation.menu;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plant.subgroup.CreateRootedPlantSubGroupDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantSubGroupEventHandler implements EventHandler<ActionEvent> {

    public AddPlantSubGroupEventHandler() {
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new CreateRootedPlantSubGroupDataModel()).handle(event);
    }
    
}
