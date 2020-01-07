package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.GwiseShapeType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 * The AreaShapeDataModel class is the model of an area which has been dragged
 * in the design pane.
 *
 * @author ZhipengChang
 */
public class AreaShapeDataModel {

    private final ObjectProperty<Point2D> mouseDraggedPosition = new SimpleObjectProperty<>();
    private final ObjectProperty<Point2D> mousePressedPosition = new SimpleObjectProperty<>();

    private final GwiseShapeType shapeType;

    public AreaShapeDataModel(GwiseShapeType shapeType, double x, double y) {

        this.shapeType = shapeType;
        mouseDraggedPosition.set(new Point2D(x, y));
        mousePressedPosition.set(new Point2D(x, y));
    }

    public ObjectProperty<Point2D> getMouseDraggedPosition() {
        return mouseDraggedPosition;
    }

    public ObjectProperty<Point2D> getMousePressedPosition() {
        return mousePressedPosition;
    }

    public GwiseShapeType getShapeType() {
        return shapeType;
    }
}
