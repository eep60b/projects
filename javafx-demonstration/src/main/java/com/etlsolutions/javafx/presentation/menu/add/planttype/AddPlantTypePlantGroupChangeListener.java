package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantsGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AddPlantTypePlantGroupChangeListener implements ChangeListener<SingleSelectionModel<PlantsGroup>> {

    private final AddPlantTypeDialogDataModel model;

    public AddPlantTypePlantGroupChangeListener(AddPlantTypeDialogDataModel model) {
        
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<PlantsGroup>> observable, SingleSelectionModel<PlantsGroup> oldValue, SingleSelectionModel<PlantsGroup> newValue) {
        
        model.setSelectedPlantGroup(newValue.getSelectedItem());
    }
}
