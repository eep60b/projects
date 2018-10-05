package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToRightEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;

    public MoveImageLinkToRightEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.incrementSelectedImageLinkIndex();
    }
    
}
