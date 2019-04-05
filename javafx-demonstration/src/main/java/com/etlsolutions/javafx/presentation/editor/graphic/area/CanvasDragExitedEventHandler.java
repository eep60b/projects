package com.etlsolutions.javafx.presentation.editor.graphic.area;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author zc
 */
public class CanvasDragExitedEventHandler implements EventHandler<DragEvent> {

    public CanvasDragExitedEventHandler() {
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

        Canvas canvas = (Canvas) event.getSource();
        canvas.getGraphicsContext2D().setFill(Color.LIGHTGRAY);
        event.consume();
    }

}
