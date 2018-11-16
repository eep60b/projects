package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantSubGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class PlantTypeChangeAdapter implements ChangeListener<PlantSubGroup> {

    private final AddPlantsDataModel model;

    public PlantTypeChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends PlantSubGroup> observable, PlantSubGroup oldValue, PlantSubGroup newValue) {
        model.setSelectedPlantType(newValue);
    }
}