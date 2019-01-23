package com.etlsolutions.javafx.presentation.dialog.area.subarea.location;

import com.etlsolutions.javafx.presentation.EditItemEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.EditSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author zc
 */
public class EditSubAreaForLocationEventHandler implements EventHandler<ActionEvent> {

    private final AbstractLocationDataModel model;
    
    public EditSubAreaForLocationEventHandler(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        new EditItemEventHandler<>(new EditSubAreaDataModel(model.getSelectedAreaValueWrapper().getValue(), model.getSelectedSubAreaValueWrapper().getValue())).handle(event);
    }
    
}
