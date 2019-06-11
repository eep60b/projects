package com.etlsolutions.javafx.presentation.editor.designtab;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author ZhipengChang
 */
public class AreaShapeDataModel {

    private final ObjectProperty<Point2D> mouseDraggedPosition = new SimpleObjectProperty<>();    
    private final ObjectProperty<Point2D> mousePressedPosition = new SimpleObjectProperty<>();    
    
    public ObjectProperty<Point2D> getMouseDraggedPosition() {
        return mouseDraggedPosition;
    }

    public ObjectProperty<Point2D> getMousePressedPosition() {
        return mousePressedPosition;
    }    
}
