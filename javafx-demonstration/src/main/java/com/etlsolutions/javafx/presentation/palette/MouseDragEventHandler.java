package com.etlsolutions.javafx.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class MouseDragEventHandler implements EventHandler<MouseEvent> {

    public MouseDragEventHandler() {
    }

    @Override
    public void handle(MouseEvent event) {
        
        ImageView v = (ImageView) event.getSource();        
        v.setMouseTransparent(true);
    }   
}
