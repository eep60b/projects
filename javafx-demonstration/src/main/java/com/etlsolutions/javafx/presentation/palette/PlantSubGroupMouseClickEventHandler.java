package com.etlsolutions.javafx.presentation.palette;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.plantsubgroup.EditPlantSubGroupDataModel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class PlantSubGroupMouseClickEventHandler implements EventHandler<MouseEvent> {

    private final PlantSubGroup subGroup;

    public PlantSubGroupMouseClickEventHandler(PlantSubGroup subGroup) {
        this.subGroup = subGroup;
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getClickCount() > 1) {
            new FXMLActionEventHandler<>(new EditPlantSubGroupDataModel(subGroup)).handle(null);
        }
    }

}
