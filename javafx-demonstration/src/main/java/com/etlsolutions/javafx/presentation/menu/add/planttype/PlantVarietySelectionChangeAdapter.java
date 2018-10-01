package com.etlsolutions.javafx.presentation.menu.add.planttype;

import com.etlsolutions.javafx.data.plant.PlantVariety;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class PlantVarietySelectionChangeAdapter implements ChangeListener<SelectionModel<PlantVariety>> {

    private final AddPlantTypeDialogDataModel model;

    public PlantVarietySelectionChangeAdapter(AddPlantTypeDialogDataModel model) {
        this.model = model;
    }

    PlantVarietySelectionChangeAdapter(Button editVarityButton, Button removeVarityButton) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<PlantVariety>> observable, SelectionModel<PlantVariety> oldValue, SelectionModel<PlantVariety> newValue) {
        model.setSelectedVariety(newValue.getSelectedItem());
    }
}
