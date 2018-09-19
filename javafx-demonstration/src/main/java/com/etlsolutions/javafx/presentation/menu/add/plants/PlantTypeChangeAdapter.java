/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
class PlantTypeChangeAdapter implements ChangeListener<SingleSelectionModel<PlantType>> {

    private final AddPlantsDataModel model;

    public PlantTypeChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<PlantType>> observable, SingleSelectionModel<PlantType> oldValue, SingleSelectionModel<PlantType> newValue) {
        model.setSelectedPlantType(newValue.getSelectedItem());
    }
}