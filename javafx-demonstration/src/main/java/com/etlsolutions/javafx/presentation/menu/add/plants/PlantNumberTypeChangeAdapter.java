package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

/**
 *
 * @author zc
 */
public class PlantNumberTypeChangeAdapter implements ChangeListener<Toggle>{

    private final AddPlantsDataModel model;

    public PlantNumberTypeChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
        model.setQuantityType(((QuantityTypeRadioButton)newValue).getType());
    }


    
}
