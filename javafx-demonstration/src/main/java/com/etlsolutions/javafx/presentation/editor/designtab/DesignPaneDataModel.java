package com.etlsolutions.javafx.presentation.editor.designtab;

import com.etlsolutions.javafx.data.area.Area;
import com.etlsolutions.javafx.data.area.AreaFactory;
import com.etlsolutions.gwise.data.area.AreaType;
import com.etlsolutions.javafx.presentation.editor.designtab.area.DesignPaneAreaDataModel;
import com.etlsolutions.gwise.system.ProjectManager;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

/**
 *
 * @author zc
 */
public class DesignPaneDataModel {

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

    
    public void drop(AreaType type) {
        
        Area area = AreaFactory.getInstance().createTypedArea(type);        
        ProjectManager.getInstance().getContents().getAreaRoot().add(area);
        ProjectManager.getInstance().addItem(area);
        ProjectManager.getInstance().getSelectedDataUnitValueWrapper().setValue(area);        
        support.firePropertyChange(AREA_DROPPED_PROPERTY, true, false);
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
