package com.etlsolutions.javafx.presentation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;

/**
 *
 * @author zc
 */
public class ContextMenuEventHandler implements EventHandler<ActionEvent>{

    private final ContextMenu contextMenu;
    private final EventHandler<ActionEvent> child;

    public ContextMenuEventHandler(ContextMenu contextMenu, EventHandler<ActionEvent> child) {
        this.contextMenu = contextMenu;
        this.child = child;
    }

    @Override
    public void handle(ActionEvent event) {
        contextMenu.hide();
        child.handle(event);
    }    
}
