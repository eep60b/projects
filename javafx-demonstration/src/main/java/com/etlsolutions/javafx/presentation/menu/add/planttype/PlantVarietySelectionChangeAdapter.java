package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class PlantVarietySelectionChangeAdapter implements ChangeListener<PlantVariety> {

    private final AddPlantTypeDataModel model;

    public PlantVarietySelectionChangeAdapter(AddPlantTypeDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends PlantVariety> observable, PlantVariety oldValue, PlantVariety newValue) {
        model.setSelectedVariety(newValue);
    }
}
