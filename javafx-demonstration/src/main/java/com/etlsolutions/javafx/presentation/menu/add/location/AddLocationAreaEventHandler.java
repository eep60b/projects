package com.etlsolutions.javafx.presentation.menu.add.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.menu.add.area.AddAreaDialogDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddLocationAreaEventHandler implements EventHandler<ActionEvent> {

    private final AddLocationDataModel model;

    public AddLocationAreaEventHandler(AddLocationDataModel model) {
    
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        AddAreaDialogDataModel areaModel = new AddAreaDialogDataModel();
        FXMLActionEventHandler<AddAreaDialogDataModel> eventHandler = new FXMLActionEventHandler<>(areaModel);
        eventHandler.handle(event);
        Area area = areaModel.getArea();
        if(area == null) {
            return;
        }        
        model.getAreas().add(area);
    }
}
