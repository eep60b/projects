package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantGroupSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private final ComboBox<PlantType> plantTypeCombox;

    public PlantGroupSelectionPropertyChangeAdapter(ComboBox<PlantType> plantTypeCombox) {
        this.plantTypeCombox = plantTypeCombox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        plantTypeCombox.setItems(((AddPlantsDataModel) evt.getSource()).getPlantTypes()); 
    }
}