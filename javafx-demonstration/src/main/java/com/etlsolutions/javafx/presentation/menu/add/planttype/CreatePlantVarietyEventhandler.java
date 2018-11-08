package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.CreateVarietyDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class CreatePlantVarietyEventhandler implements EventHandler<ActionEvent> {

    private final AddPlantTypeDataModel model;

    public CreatePlantVarietyEventhandler(AddPlantTypeDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        CreateVarietyDataModel varietyDataModel = new CreateVarietyDataModel();        
        new FXMLActionEventHandler<>(varietyDataModel).handle(event);
        
        PlantVariety variety = varietyDataModel.get();
        
        if(variety == null) {
            return;
        }
        
        model.getVarieties().add(variety);
    }
}
