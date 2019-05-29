package com.etlsolutions.javafx.presentation.editor.designtab.area;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author ZhipengChang
 */
public class AreaDragExitedEventHandler implements EventHandler<DragEvent> {

    private final StackPane designPane;

    public AreaDragExitedEventHandler(StackPane designPane) {
        this.designPane = designPane;
    }

    @Override
    public void handle(DragEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
