package com.etlsolutions.javafx.presentation.editor.graphic.area;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author zc
 */
public class CanvasDragEnteredEventHandler implements EventHandler<DragEvent> {


    /**
     * TODO:
     *
     * 1. detect the location.
     *
     * 2. Calculate if the object can be dropped.
     *
     * 3. Display the correct culsor.
     *
     * 4. shade the area occupied. (Add a shape same as the source object)
     *
     * @param event
     */
    @Override
    public void handle(DragEvent event) {

        Canvas canvas = (Canvas) event.getSource();
        canvas.getGraphicsContext2D().setFill(Color.BROWN);

        event.consume();
    }

}
