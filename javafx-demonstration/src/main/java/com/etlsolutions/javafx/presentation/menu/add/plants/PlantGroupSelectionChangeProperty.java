/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public PlantGroupSelectionChangeProperty(AddPlantsDataModel model) {
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<PlantGroup>> observable, SingleSelectionModel<PlantGroup> oldValue, SingleSelectionModel<PlantGroup> newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
