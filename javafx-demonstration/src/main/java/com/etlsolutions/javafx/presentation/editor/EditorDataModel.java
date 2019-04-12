package com.etlsolutions.javafx.presentation.editor;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author zc
 */
public class EditorDataModel {
    
    private final  ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();

    public ObjectProperty<Point2D> getMousePosition() {
        return mousePosition;
    }    
}
