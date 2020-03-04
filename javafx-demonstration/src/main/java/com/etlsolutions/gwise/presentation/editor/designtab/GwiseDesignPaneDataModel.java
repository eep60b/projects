package com.etlsolutions.gwise.presentation.editor.designtab;

import com.etlsolutions.javafx.presentation.editor.designtab.area.DesignPaneAreaDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author zc
 */
public class GwiseDesignPaneDataModel {

    public static final String AREA_DROPPED_PROPERTY = DesignPaneAreaDataModel.class.getName() + ".AREA_DROPPED_PROPERTY";

    private final ObjectProperty<Point2D> mousePressedPosition = new SimpleObjectProperty<>();
    private final ObjectProperty<Point2D> mouseCurrentPosition = new SimpleObjectProperty<>();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ObjectProperty<Point2D> getMousePressedPosition() {
        return mousePressedPosition;
    }

    public ObjectProperty<Point2D> getMouseCurrentPosition() {
        return mouseCurrentPosition;
    }

    public boolean isMousePressedPositionAvaiable() {

        // In an area, available if the source is an subarea.
        // In an subarea, available is the source is a plant type.
        return true;
    }

    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
    }

    public boolean hasListeners(String propertyName) {
        return support.hasListeners(propertyName);
    }   
}
