package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDataModel;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * 1. Check if the mouse position is in/on the area/subarea/location/plants.
 *
 * 2.  
 * @author zc
 */
public final class MousePressedEventHandler implements EventHandler<MouseEvent> {

    private final DesignPaneDataModel model;

    public MousePressedEventHandler(DesignPaneDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        
        
        
        model.getMousePressedPosition().set(new Point2D(event.getSceneX(), event.getSceneY()));
    }

}
