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

    private final Removable model;
    private final RemoveEventId id;

    public RemoveEventHandler(Removable model, RemoveEventId id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public void handle(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete " + id.getItemName() + "?\nThis operation is irreversible.", ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            model.remove(id);
        }
    }

}
