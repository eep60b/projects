package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.AddSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddSubAreaForLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;

    public AddSubAreaForLocationEventHandler(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getSubAreas(), model.getSelectedSubAreaValueWrapper(), new AddSubAreaDataModel(model.getSelectedAreaValueWrapper().getValue())).handle(event);
    }
    
}
