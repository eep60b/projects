package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToEndEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;

    public MoveImageLinkToEndEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        ObservableListWrapperA list = model.getImageLinks();
        model.getSelectedImageLinkWrapper().setValue(list.get(list.size() - 1));
    }
    
}
