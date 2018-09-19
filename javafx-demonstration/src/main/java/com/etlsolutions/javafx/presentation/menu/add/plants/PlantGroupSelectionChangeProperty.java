package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class PlantGroupSelectionChangeProperty implements ChangeListener<SingleSelectionModel<PlantGroup>> {

    private final AddPlantsDataModel model;

    public PlantGroupSelectionChangeProperty(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<PlantGroup>> observable, SingleSelectionModel<PlantGroup> oldValue, SingleSelectionModel<PlantGroup> newValue) {
        model.setSelectedPlantGroup(newValue.getSelectedItem());
    } 
}
