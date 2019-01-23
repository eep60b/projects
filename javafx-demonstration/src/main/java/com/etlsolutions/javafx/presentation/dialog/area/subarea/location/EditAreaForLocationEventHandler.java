/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.EditAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditAreaForLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;

    public EditAreaForLocationEventHandler(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditAreaDataModel(model.getSelectedAreaValueWrapper().getValue())).handle(event);
    }
    
}
