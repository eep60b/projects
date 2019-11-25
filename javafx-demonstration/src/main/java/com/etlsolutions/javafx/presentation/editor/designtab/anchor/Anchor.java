package com.etlsolutions.javafx.presentation.editor.designtab.anchor;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author zc
 */
public class Anchor extends Circle {

    private final AnchorDoubleProperty xProperty;
    private final AnchorDoubleProperty yProperty;

    public Anchor() {
      
        Color color = Color.GOLD;
        
        setFill(color.deriveColor(1, 1, 1, 0.5));
        setStroke(color);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);

        xProperty = new AnchorDoubleProperty(this, "x");
        yProperty = new AnchorDoubleProperty(this, "y");

        xProperty.bind(centerXProperty());
        xProperty.bind(centerYProperty());
        enableDrag();
        
    }

    // make a node movable by dragging it around with the mouse.
    private void enableDrag() {
        final Delta dragDelta = new Delta();
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = getCenterX() - mouseEvent.getX();
                dragDelta.y = getCenterY() - mouseEvent.getY();
                getScene().setCursor(Cursor.MOVE);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getScene().setCursor(Cursor.HAND);
            }
        });
        
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double newX = mouseEvent.getX() + dragDelta.x;
                if (newX > 0 && newX < getScene().getWidth()) {
                    setCenterX(newX);
                }
                double newY = mouseEvent.getY() + dragDelta.y;
                if (newY > 0 && newY < getScene().getHeight()) {
                    setCenterY(newY);
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.HAND);
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.DEFAULT);
                }
            }
        });
    }

    public AnchorDoubleProperty getXProperty() {
        return xProperty;
    }

    public AnchorDoubleProperty getYProperty() {
        return yProperty;
    }   
    
    // records relative x and y co-ordinates.
    private class Delta {
        double x, y;
    }
}
