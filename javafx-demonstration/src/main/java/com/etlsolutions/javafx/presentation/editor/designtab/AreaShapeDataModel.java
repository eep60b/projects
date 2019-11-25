package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.AreaShape;
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
    
    private final AreaShape areaShape;

    public AreaShapeDataModel(AreaShape areaShape) {
        this.areaShape = areaShape;
    }
    
    public ObjectProperty<Point2D> getMouseDraggedPosition() {
        return mouseDraggedPosition;
    }

    public ObjectProperty<Point2D> getMousePressedPosition() {
        return mousePressedPosition;
    }    

    public AreaShape getAreaShape() {
        return areaShape;
    }
}
