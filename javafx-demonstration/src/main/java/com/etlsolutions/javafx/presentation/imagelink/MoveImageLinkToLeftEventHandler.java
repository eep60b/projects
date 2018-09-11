package com.etlsolutions.javafx.presentation.imagelink;

import com.etlsolutions.javafx.presentation.DataUnitDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToLeftEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitDataModel model;

    public MoveImageLinkToLeftEventHandler(DataUnitDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        model.decrementSelectedImageLinkIndex();
    }
    
}
