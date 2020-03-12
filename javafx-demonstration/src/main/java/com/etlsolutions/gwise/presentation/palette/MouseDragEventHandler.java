package com.etlsolutions.gwise.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseDragEventHandler implements EventHandler<MouseEvent> {
    
    @Override
    public void handle(MouseEvent event) {
        event.setDragDetect(false);
    }    
}
