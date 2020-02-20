package com.etlsolutions.javafx.presentation;

import com.etlsolutions.gwise.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.imagelink.AddImageToFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class AddImageToDataUnitFXMLDataModelEventHandler implements EventHandler<ActionEvent> {

    DataUnitFXMLDataModel model;

    public AddImageToDataUnitFXMLDataModelEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new AddImageToFXMLDataModel(model)).handle(event);
    }
}
