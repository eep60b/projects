package com.etlsolutions.gwise.presentation.dialog.imagelink;

import com.etlsolutions.gwise.presentation.GwiseDataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class GwiseMoveImageLinkToBeginEventHandler implements EventHandler<ActionEvent> {

    private final GwiseDataUnitFXMLDataModel model;

    public GwiseMoveImageLinkToBeginEventHandler(GwiseDataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.getSelectedImageLinkWrapper().setValue(model.getImageLinks().get(0));
    } 
}
