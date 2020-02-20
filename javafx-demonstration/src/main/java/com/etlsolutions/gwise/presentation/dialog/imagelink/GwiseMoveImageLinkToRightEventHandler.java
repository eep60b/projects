package com.etlsolutions.gwise.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.gwise.data.ObservableListWrapperA;
import com.etlsolutions.gwise.data.ValueWrapper;
import com.etlsolutions.gwise.presentation.GwiseDataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class GwiseMoveImageLinkToRightEventHandler implements EventHandler<ActionEvent> {

    private final GwiseDataUnitFXMLDataModel model;

    public GwiseMoveImageLinkToRightEventHandler(GwiseDataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        ValueWrapper<ImageLink> wrapper = model.getSelectedImageLinkWrapper();
        ObservableListWrapperA<ImageLink> list = model.getImageLinks();
        wrapper.setValue(list.get(list.indexOf(wrapper.getValue()) + 1));
    }
    
}
