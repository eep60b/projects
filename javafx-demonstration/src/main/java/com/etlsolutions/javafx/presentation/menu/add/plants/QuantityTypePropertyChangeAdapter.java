/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.PlantsQuantity.Type;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Spinner;

/**
 *
 * @author zc
 */
public class QuantityTypePropertyChangeAdapter implements PropertyChangeListener {

    private final Spinner<Integer> plantNumberSpinner;

    public QuantityTypePropertyChangeAdapter(Spinner<Integer> plantNumberSpinner) {
        
        this.plantNumberSpinner = plantNumberSpinner;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddPlantsDataModel model = (AddPlantsDataModel) evt.getSource();
        plantNumberSpinner.getValueFactory().setValue(model.getPlantNumber());
        Type type = model.getQuantityType();
        plantNumberSpinner.setDisable(type == Type.SINGLE || type == Type.NO_COUNTING);
    }
}
