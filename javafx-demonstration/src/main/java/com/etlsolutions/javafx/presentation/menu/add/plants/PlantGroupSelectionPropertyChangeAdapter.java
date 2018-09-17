package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantsType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantGroupSelectionPropertyChangeAdapter implements PropertyChangeListener {

    public PlantGroupSelectionPropertyChangeAdapter(ComboBox<PlantsType> plantTypeCombox) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
