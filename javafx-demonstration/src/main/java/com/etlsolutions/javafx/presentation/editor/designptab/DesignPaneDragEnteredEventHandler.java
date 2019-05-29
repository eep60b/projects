package com.etlsolutions.javafx.presentation.editor.designptab;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author zc
 */
public class DesignPaneDragEnteredEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;

    public DesignPaneDragEnteredEventHandler(StackPane designPane) {
        this.designPane = designPane;
    }

    /**
     * TODO:
     *
     * 1. detect the location.
     *
     * 2. Calculate if the object can be dropped.
     *
     * 3. Display the correct cursor.
     *
     * 4. shade the area occupied. (Add a shape same as the source object)
     *
     * @param event
     */
    @Override
    public void handle(DragEvent event) {

        designPane.getScene().setCursor(Cursor.CROSSHAIR);
    }
}
