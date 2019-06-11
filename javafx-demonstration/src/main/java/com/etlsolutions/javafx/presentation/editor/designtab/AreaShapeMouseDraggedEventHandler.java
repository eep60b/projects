package com.etlsolutions.javafx.presentation.editor.designtab;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * The AreaShapeMouseDraggedEventHandler class handles the drag event for the
 * area shape, The area should move with the mouse.
 *
 *
 * @author ZhipengChang
 */
public class AreaShapeMouseDraggedEventHandler implements EventHandler<MouseEvent> {

    private final AreaShapeDataModel model;

    public AreaShapeMouseDraggedEventHandler(AreaShapeDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        
        model.getMouseDraggedPosition().setValue(new Point2D(event.getX(), event.getY()));        
    }
}
