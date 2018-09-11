package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToBeginEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitDataModel model;

    public MoveImageLinkToBeginEventHandler(DataUnitDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.setSelectedImageLinkToFirst();
    }
    
}
