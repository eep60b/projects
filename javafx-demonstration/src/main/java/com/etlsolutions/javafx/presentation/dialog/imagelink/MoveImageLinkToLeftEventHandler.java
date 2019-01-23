package com.etlsolutions.javafx.presentation.dialog.imagelink;

import com.etlsolutions.javafx.data.ImageLink;
import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.presentation.DataUnitFXMLDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class MoveImageLinkToLeftEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;

    public MoveImageLinkToLeftEventHandler(DataUnitFXMLDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        ValueWrapper<ImageLink> wrapper = model.getSelectedImageLinkWrapper();
        ObservableListWrapperA<ImageLink> list = model.getImageLinks();
        wrapper.setValue(list.get(list.indexOf(wrapper.getValue()) - 1));
    }    
}
