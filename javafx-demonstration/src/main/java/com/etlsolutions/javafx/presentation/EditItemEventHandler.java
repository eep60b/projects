package com.etlsolutions.javafx.presentation;

import com.etlsolutions.javafx.data.DataUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 * @param <D>
 */
public class EditItemEventHandler<D extends DataUnit> implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel<D> model;

    public EditItemEventHandler(DataUnitFXMLDataModel<D> model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(model).handle(event);
    }  
}
