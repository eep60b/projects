package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plant.plantvariety.AddVarietyDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class AddVarityToPlantEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    public AddVarityToPlantEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        AddVarietyDataModel varietyDataModel = new AddVarietyDataModel(model.getPlantSubGroupValueWrapper().getValue());
        new FXMLActionEventHandler<>(varietyDataModel).handle(event);
        
        PlantVariety variety = varietyDataModel.get();
        if(variety != null) {
            model.getPlantVarieties().add(variety);
            model.getPlantVarietyValueWrapper().setValue(variety);
        }
    }
    
}
