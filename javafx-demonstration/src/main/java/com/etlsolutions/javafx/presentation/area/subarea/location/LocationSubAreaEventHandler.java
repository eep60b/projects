package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.area.AbstractAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class LocationSubAreaEventHandler implements EventHandler<ActionEvent> {

    private final AddLocationDataModel model;
    private final SubArea subArea;

    public LocationSubAreaEventHandler(AddLocationDataModel model, SubArea subArea) {
    
        this.model = model;
        this.subArea = subArea;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
