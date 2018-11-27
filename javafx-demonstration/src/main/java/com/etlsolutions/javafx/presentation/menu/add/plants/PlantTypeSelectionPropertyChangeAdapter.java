package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.ValueWrapper;
import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantTypeSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private AddPlantsDataModel model;
    private final ComboBox<PlantSubGroup> plantTypeCombox;


    public PlantTypeSelectionPropertyChangeAdapter(AddPlantsDataModel model, ComboBox<PlantSubGroup> plantTypeCombox) {
        this.model = model;
        this.plantTypeCombox = plantTypeCombox;
    }

    PlantTypeSelectionPropertyChangeAdapter(ComboBox<PlantSubGroup> plantTypeCombox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        ValueWrapper<PlantSubGroup> wrapper = (ValueWrapper<PlantSubGroup>) evt.getSource();
        this.plantTypeCombox.getSelectionModel().select(wrapper.getValue());
        
        model.getPlantVarieties().clear();
        model.getPlantVarieties().addAll(wrapper.getValue().getPlantVarieties());
    }
}
