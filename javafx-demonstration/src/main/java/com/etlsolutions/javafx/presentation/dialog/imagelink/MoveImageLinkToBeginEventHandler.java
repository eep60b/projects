package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToBeginEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;

    public MoveImageLinkToBeginEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.getSelectedImageLinkWrapper().setValue(model.getImageLinks().get(0));
    } 
}
