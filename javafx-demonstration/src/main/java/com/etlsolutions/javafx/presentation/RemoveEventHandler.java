package com.etlsolutions.javafx.presentation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author zc
 */
public class RemoveEventHandler implements EventHandler<ActionEvent> {

    private final DataUnitFXMLDataModel model;
    private final Object item;

    public RemoveEventHandler(DataUnitFXMLDataModel model, Object item) {
        this.model = model;
        this.item = item;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete " + item.toString() + "?\nThis operation is irreversible.", ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            model.remove(item);
        }
    }

}
