package com.etlsolutions.javafx.presentation.editor.designptab;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author zc
 */
public class DesignPaneDragExitedEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;

    public DesignPaneDragExitedEventHandler(StackPane designPane) {
        this.designPane = designPane;
    }

    /**
     * TODO:
     * 
     * 1. remove the shade the area occupied.
     *
     * @param event
     */
    @Override
    public void handle(DragEvent event) {

        designPane.getScene().setCursor(Cursor.CROSSHAIR);
    }
}
