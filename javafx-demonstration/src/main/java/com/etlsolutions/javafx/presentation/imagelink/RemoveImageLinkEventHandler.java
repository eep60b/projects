package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class RemoveImageLinkEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;

    public RemoveImageLinkEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.removeSelectedImageLink();
    }
    
}
