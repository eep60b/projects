package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.planttype.AddPlantTypeDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantTypeEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantsDataModel model;

    
    public AddPlantTypeEventHandler(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        AddPlantTypeDataModel addPlantTypeDataModel = new AddPlantTypeDataModel();        
        new FXMLActionEventHandler<>(addPlantTypeDataModel).handle(event);
        
        PlantSubGroup type = addPlantTypeDataModel.get();
        if(type != null) {
            model.getPlantTypes().add(type);
            model.getPlantSubGroupValueWrapper().setValue(type);
        }
    }
}
