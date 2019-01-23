package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.presentation.AddItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.AddAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class AddAreaForLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;

    public AddAreaForLocationEventHandler(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new AddItemEventHandler<>(model.getAreas(), model.getSelectedAreaValueWrapper(), new AddAreaDataModel()).handle(event);
    }
    
}
