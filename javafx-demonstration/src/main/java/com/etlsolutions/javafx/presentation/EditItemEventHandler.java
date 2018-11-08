package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 * @param <T>
 */
public class EditItemEventHandler<T> implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel<T> model;

    public EditItemEventHandler(DataUnitFXMLDataModel<T> model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(model).handle(event);
    }  
}
