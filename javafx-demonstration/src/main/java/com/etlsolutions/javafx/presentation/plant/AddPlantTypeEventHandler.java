package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.plant.subgroup.AbstractPlantSubGroupDataModel;
import com.etlsolutions.javafx.presentation.plant.subgroup.AddPlantSubGroupDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddPlantTypeEventHandler implements EventHandler<ActionEvent> {

    private final AddPlantDataModel model;

    
    public AddPlantTypeEventHandler(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {

        AbstractPlantSubGroupDataModel addPlantTypeDataModel = new AddPlantSubGroupDataModel();        
        new FXMLActionEventHandler<>(addPlantTypeDataModel).handle(event);
        
        PlantSubGroup type = addPlantTypeDataModel.get();
        if(type != null) {
            model.getPlantTypes().add(type);
            model.getPlantSubGroupValueWrapper().setValue(type);
        }
    }
}
