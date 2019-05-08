package com.etlsolutions.javafx.presentation.editor.model;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.presentation.editor.model.DesignPaneAreaDataModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author zc
 */
public class DesignPaneDataModel {
    
    
    private DesignPaneAreaDataModel designPaneAreaDataModel;
    
    private final  ObjectProperty<Point2D> mousePressedPosition = new SimpleObjectProperty<>();
    private final  ObjectProperty<Point2D> mouseCurrentPosition = new SimpleObjectProperty<>();

    public ObjectProperty<Point2D> getMousePressedPosition() {
        return mousePressedPosition;
    }

    public ObjectProperty<Point2D> getMouseCurrentPosition() {
        return mouseCurrentPosition;
    }
    
    boolean isMousePressedPositionAvaiable() {
        
        // In an area, available if the source is an subarea.
        // In an subarea, available is the source is a plant type.
        
        
        return true;
    }

    public void drop(double mouseX, double mouseY, PlantSubGroup subGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
