package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantVariety;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantVarietyPropertyChangeAdapter implements PropertyChangeListener {

    private final ComboBox<PlantVariety> plantVarietyCombobox;

    public PlantVarietyPropertyChangeAdapter(ComboBox<PlantVariety> plantVarietyCombobox) {
        
        this.plantVarietyCombobox = plantVarietyCombobox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<PlantVariety> wrapper = (ValueWrapper<PlantVariety>) evt.getSource();
        plantVarietyCombobox.getSelectionModel().select(wrapper.getValue());
    }
    
}
