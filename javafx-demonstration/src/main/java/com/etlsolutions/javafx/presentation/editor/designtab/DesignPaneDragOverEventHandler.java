package com.etlsolutions.javafx.presentation.editor.designtab;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 *
 * @author zc
 */
public class DesignPaneDragOverEventHandler implements EventHandler<DragEvent> {

    public DesignPaneDragOverEventHandler() {
    }

    @Override
    public void handle(DragEvent event) {
         event.acceptTransferModes(TransferMode.COPY); 
         event.consume();
    }
    
}
