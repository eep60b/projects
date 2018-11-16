package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantTypeSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private final ComboBox<PlantSubGroup> plantTypeCombox;

    public PlantTypeSelectionPropertyChangeAdapter(ComboBox<PlantSubGroup> plantTypeCombox) {
        
        this.plantTypeCombox = plantTypeCombox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        AddPlantsDataModel model = (AddPlantsDataModel) evt.getSource();
        this.plantTypeCombox.getSelectionModel().select(model.getSelectedPlantType());
    }
}
