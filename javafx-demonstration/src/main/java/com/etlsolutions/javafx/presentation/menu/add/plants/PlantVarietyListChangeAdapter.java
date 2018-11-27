package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantVarietyListChangeAdapter implements ListChangeListener<PlantVariety> {

    private final ComboBox<PlantVariety> plantVarietyCombobox;
    private final AddPlantsDataModel model;

    public PlantVarietyListChangeAdapter(ComboBox<PlantVariety> plantVarietyCombobox, AddPlantsDataModel model) {
        
        this.plantVarietyCombobox = plantVarietyCombobox;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends PlantVariety> c) {
        
        plantVarietyCombobox.setItems(model.getPlantVarieties());
        
        PlantVariety v = model.getPlantVarietyValueWrapper().getValue();
        if(!model.getPlantVarieties().contains(v)) {
            model.getPlantVarietyValueWrapper().setValue(model.getPlantVarieties().isEmpty() ? null : model.getPlantVarieties().get(0));
        }
    }
    
}
