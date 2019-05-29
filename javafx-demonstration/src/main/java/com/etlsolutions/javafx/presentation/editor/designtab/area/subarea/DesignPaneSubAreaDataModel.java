package com.etlsolutions.javafx.presentation.editor.designtab.area.subarea;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import com.etlsolutions.javafx.data.plant.PlantValueWrapper;
import com.etlsolutions.javafx.presentation.editor.designtab.area.DesignPaneAreaDataModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.geometry.Point2D;

/**
 *
 * @author ZhipengChang
 */
public class DesignPaneSubAreaDataModel {

    public static final String PLANT_SUBGROUP_DROPPED_PROPERTY = DesignPaneAreaDataModel.class.getName() + ".PLANT_SUBGROUP_DROPPED_PROPERTY";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);    
    private final SubArea subArea;
    private final ObservableListWrapperA<PlantValueWrapper> plantSets = new ObservableListWrapperA<>();
    
    public DesignPaneSubAreaDataModel(SubArea subArea) {
        this.subArea = subArea;
    }

    public ObservableListWrapperA<PlantValueWrapper> getPlantSets() {
        return plantSets;
    }    
    
    public boolean isInMyArea(Point2D point) {
        return true;
    }    

    void drop(PlantSubGroup subGroup) {
        
                 //Create a default Location
        // Create a default Plants
        
        support.firePropertyChange(PLANT_SUBGROUP_DROPPED_PROPERTY, true, false);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
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
