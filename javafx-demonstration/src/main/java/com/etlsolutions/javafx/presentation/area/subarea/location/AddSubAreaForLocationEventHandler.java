/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.area.subarea.AddSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddSubAreaForLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;

    public AddSubAreaForLocationEventHandler(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getSubAreas(), model.getSelectedSubAreaValueWrapper(), new AddSubAreaDataModel(model.getSelectedAreaValueWrapper().getValue())).handle(event);
    }
    
}
