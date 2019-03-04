package com.etlsolutions.javafx.presentation.editor;

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

    @Override
    public void handle(DragEvent event) {
        
  
        event.consume();
    }
    
}
