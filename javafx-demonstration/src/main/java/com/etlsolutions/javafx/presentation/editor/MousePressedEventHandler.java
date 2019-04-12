package com.etlsolutions.javafx.presentation.editor;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author zc
 */
public final class MousePressedEventHandler implements EventHandler<MouseEvent> {

    private final EditorDataModel model;

    public MousePressedEventHandler(EditorDataModel model) {
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        model.getMousePosition().set(new Point2D(event.getSceneX(), event.getSceneY()));
    }
    
}
