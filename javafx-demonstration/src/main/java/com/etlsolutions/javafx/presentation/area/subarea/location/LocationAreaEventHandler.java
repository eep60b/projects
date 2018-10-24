package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.AbstractAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class LocationAreaEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;
    private final AbstractAreaDataModel areaModel;

    public LocationAreaEventHandler(AbstractLocationDataModel model, AbstractAreaDataModel areaModel) {
    
        this.model = model;
        this.areaModel = areaModel;
    }

    @Override
    public void handle(ActionEvent event) {
        FXMLActionEventHandler<AbstractAreaDataModel> eventHandler = new FXMLActionEventHandler<>(areaModel);
        eventHandler.handle(event);
        Area area = areaModel.getArea();
        if(area == null) {
            return;
        }        
        model.getAreas().add(area);
    }
}
