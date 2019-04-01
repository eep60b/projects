package com.etlsolutions.javafx.presentation.editor.graphic.area;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;

/**
 *
 * @author zc
 */
public class CanvasDragEnteredEventHandler implements EventHandler<DragEvent> {

    private final Canvas canvas;

    public CanvasDragEnteredEventHandler(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * TODO:
     *
     * 1. detect the location. 
     * 
     * 2, Calculate if the object can be dropped. 
     * 
     * 3. Display the correct culsor. 
     * 
     * 4. shade the area.
     *
     * @param event
     */
    @Override
    public void handle(DragEvent event) {

        event.consume();
    }

}
