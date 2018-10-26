package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class PlantTypeChangeAdapter implements ChangeListener<PlantType> {

    private final AddPlantsDataModel model;

    public PlantTypeChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends PlantType> observable, PlantType oldValue, PlantType newValue) {
        model.setSelectedPlantType(newValue);
    }
}