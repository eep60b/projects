package com.etlsolutions.gwise.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * The MousePressEventHandler class handles the event when an object is dragged.
 *
 * @author zc
 */
public class MousePressEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        Node source = (Node) event.getSource();
        source.setMouseTransparent(true);
        event.setDragDetect(true);
    }
}
