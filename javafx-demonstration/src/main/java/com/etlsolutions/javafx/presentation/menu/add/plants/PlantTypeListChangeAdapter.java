package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantTypeListChangeAdapter implements ListChangeListener<PlantSubGroup> {
    
    private final AddPlantsDataModel model;
    private final ComboBox<PlantSubGroup> plantTypeCombox;
    
    public PlantTypeListChangeAdapter(ComboBox<PlantSubGroup> plantTypeCombox, AddPlantsDataModel model) {
        this.plantTypeCombox = plantTypeCombox;
        this.model = model;
    }
    
    @Override
    public void onChanged(Change<? extends PlantSubGroup> c) {
        plantTypeCombox.setItems(model.getPlantTypes());
        PlantSubGroup subGroup = model.getPlantSubGroupValueWrapper().getValue();
        
        if (!model.getPlantTypes().contains(subGroup)) {
            model.getPlantSubGroupValueWrapper().setValue(model.getPlantTypes().isEmpty() ? null : model.getPlantTypes().get(0));
        }
        
    }
    
}
