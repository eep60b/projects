package com.etlsolutions.gwise.presentation.dialog.imagelink;

import com.etlsolutions.gwise.presentation.GwiseDataUnitFXMLDataModel;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class GwiseMoveImageLinkToEndEventHandler implements EventHandler<ActionEvent> {

    private final GwiseDataUnitFXMLDataModel model;

    public GwiseMoveImageLinkToEndEventHandler(GwiseDataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        ObservableListWrapperA list = model.getImageLinks();
        model.getSelectedImageLinkWrapper().setValue(list.get(list.size() - 1));
    }
    
}
