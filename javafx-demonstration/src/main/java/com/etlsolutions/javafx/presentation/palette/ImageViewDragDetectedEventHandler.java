package com.etlsolutions.javafx.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class ImageViewDragDetectedEventHandler implements EventHandler<MouseEvent> {

    public ImageViewDragDetectedEventHandler() {
    }

    @Override
    public void handle(MouseEvent event) {
        event.getSource();
    }
    
}
