package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.AbstractSubAreaDataModel;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class LocationSubAreaEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;
    private final AbstractSubAreaDataModel addSubAreaDataModel;

    public LocationSubAreaEventHandler(AbstractLocationDataModel model, AbstractSubAreaDataModel addSubAreaDataModel) {

        this.model = model;
        this.addSubAreaDataModel =addSubAreaDataModel;
    }

    @Override
    public void handle(ActionEvent event) {
        
        FXMLActionEventHandler<AbstractSubAreaDataModel> eventHandler = new FXMLActionEventHandler<>(addSubAreaDataModel);
        eventHandler.handle(event);
        SubArea subArea = addSubAreaDataModel.getSubArea();
        if (subArea == null) {
            return;
        }
        model.getSubAreas().add(subArea);
        model.setSelectedSubArea(subArea);
    }
}
