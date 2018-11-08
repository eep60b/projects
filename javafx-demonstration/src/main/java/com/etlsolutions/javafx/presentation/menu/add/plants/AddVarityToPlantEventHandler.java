package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.plantvariety.AddVarietyDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class AddVarityToPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    public AddVarityToPlantEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddVarietyDataModel varietyDataModel = new AddVarietyDataModel(model.getSelectedPlantType());
        new FXMLActionEventHandler<>(varietyDataModel).handle(event);
        
        PlantVariety variety = varietyDataModel.get();
        if(variety != null) {
            model.getPlantVarieties().add(variety);
            model.setSelectedVariety(variety);
        }
    }
    
}
