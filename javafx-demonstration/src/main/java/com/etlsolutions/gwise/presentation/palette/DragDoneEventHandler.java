package com.etlsolutions.gwise.presentation.palette;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;

/**
 *
 * @author zc
 */
public class DragDoneEventHandler implements EventHandler<DragEvent> {

    @Override
    public void handle(DragEvent event) {

        //TODO: Recover the image colour.
        Node source = (Node) event.getSource();

  //      source.setStyle(value);
        event.consume();
    }

}
