package com.etlsolutions.javafx.presentation.plant;

import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

/**
 *
 * @author zc
 */
public class PlantNumberTypeChangeAdapter implements ChangeListener<Toggle>{

    private final AddPlantDataModel model;

    public PlantNumberTypeChangeAdapter(AddPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
        model.getQuantityTypeValueWrapper().setValue(((QuantityTypeRadioButton)newValue).getType());
    }


    
}
