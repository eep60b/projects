package com.etlsolutions.gwise.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public class DragDetectedEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
       
        Node source = (Node) event.getSource(); 
        //TODO: set the image color darker.
        String s = source.getStyle();
        
        source.startFullDrag();
        event.consume();
    }
    
}
