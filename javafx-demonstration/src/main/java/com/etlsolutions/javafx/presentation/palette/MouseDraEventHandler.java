package com.etlsolutions.javafx.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class MouseDraEventHandler implements EventHandler<MouseEvent> {

    public MouseDraEventHandler() {
    }

    @Override
    public void handle(MouseEvent event) {
        event.setDragDetect(false);
    }    
}
