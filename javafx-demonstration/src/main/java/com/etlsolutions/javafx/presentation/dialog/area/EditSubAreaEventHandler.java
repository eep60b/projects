package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.javafx.presentation.FXMLActionEventHandler;
import com.etlsolutions.javafx.presentation.dialog.area.subarea.EditSubAreaDataModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Zhipeng
 */
public class EditSubAreaEventHandler implements EventHandler<ActionEvent> {

    private final AbstractAreaDataModel model;

    public EditSubAreaEventHandler(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        EditSubAreaDataModel editModel = new EditSubAreaDataModel(model.get(), model.getSelectedSubArea().getValue());
        new FXMLActionEventHandler<>(editModel).handle(event);
    }
}
