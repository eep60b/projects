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
public class SelectPlantGroupChangeAdapter implements ChangeListener<SingleSelectionModel<PlantGroup>> {

    private final GroupSelectable model;

    public SelectPlantGroupChangeAdapter(GroupSelectable model) {
        
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<PlantGroup>> observable, SingleSelectionModel<PlantGroup> oldValue, SingleSelectionModel<PlantGroup> newValue) {
        
        model.setSelectedPlantGroup(newValue.getSelectedItem());
    }
}
