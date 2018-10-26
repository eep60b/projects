package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.data.plant.PlantGroup;
import com.etlsolutions.javafx.presentation.plant.GroupSelectable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class SelectPlantGroupChangeAdapter implements ChangeListener<PlantGroup> {

    private final GroupSelectable model;

    public SelectPlantGroupChangeAdapter(GroupSelectable model) {
        
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends PlantGroup> observable, PlantGroup oldValue, PlantGroup newValue) {
        model.setSelectedPlantGroup(newValue);
    }
}
