package com.etlsolutions.gwise.presentation;

import com.etlsolutions.gwise.presentation.dialog.imagelink.GwiseAddImageToFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class GwiseAddImageToDataUnitFXMLDataModelEventHandler implements EventHandler<ActionEvent> {

    GwiseDataUnitFXMLDataModel model;

    public GwiseAddImageToDataUnitFXMLDataModelEventHandler(GwiseDataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new FXMLActionEventHandler<>(new GwiseAddImageToFXMLDataModel(model)).handle(event);
    }
}
