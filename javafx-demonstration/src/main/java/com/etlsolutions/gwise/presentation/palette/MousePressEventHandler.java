package com.etlsolutions.gwise.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * The MousePressEventHandler class handles the event when an object is dragged. 
 * @author zc
 */
public class MousePressEventHandler implements EventHandler<MouseEvent> {

    public MousePressEventHandler() {
    }

    @Override
    public void handle(MouseEvent event) {

        event.setDragDetect(false);
        ImageView v = (ImageView) event.getSource();
        v.setMouseTransparent(true);
    }
}
