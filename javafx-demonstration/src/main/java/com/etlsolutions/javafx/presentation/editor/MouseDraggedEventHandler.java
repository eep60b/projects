package com.etlsolutions.javafx.presentation.editor;

import com.etlsolutions.javafx.presentation.editor.designtab.DesignPaneDataModel;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 *
 * @author zc
 */
public final class MouseDraggedEventHandler implements EventHandler<MouseEvent> {

    private final DesignPaneDataModel model;

    public MouseDraggedEventHandler(DesignPaneDataModel model) {

        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {

        Shape shape = (Shape) event.getSource();

        double deltaX = event.getSceneX() - model.getMousePressedPosition().get().getX();
        double deltaY = event.getSceneY() - model.getMousePressedPosition().get().getY();
        shape.setLayoutX(shape.getLayoutX() + deltaX);
        shape.setLayoutY(shape.getLayoutY() + deltaY);
        model.getMouseCurrentPosition().set(new Point2D(event.getSceneX(), event.getSceneY()));
    }
}
