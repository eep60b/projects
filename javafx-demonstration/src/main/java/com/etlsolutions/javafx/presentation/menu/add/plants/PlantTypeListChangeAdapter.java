package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantType;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class PlantTypeListChangeAdapter implements ListChangeListener<PlantType> {

    private final AddPlantsDataModel model;
    private final ComboBox<PlantType> plantTypeCombox;

    public PlantTypeListChangeAdapter(ComboBox<PlantType> plantTypeCombox, AddPlantsDataModel model) {
        this.plantTypeCombox = plantTypeCombox;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends PlantType> c) {
        plantTypeCombox.setItems(model.getPlantTypes());
    }
    
}
