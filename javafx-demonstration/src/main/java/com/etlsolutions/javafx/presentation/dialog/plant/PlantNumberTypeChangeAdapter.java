package com.etlsolutions.javafx.presentation.dialog.plant;

import com.etlsolutions.javafx.presentation.QuantityTypeRadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

/**
 *
 * @author zc
 */
public class PlantNumberTypeChangeAdapter implements ChangeListener<Toggle>{

    private final AbstractPlantDataModel model;

    public PlantNumberTypeChangeAdapter(AbstractPlantDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
        model.getQuantityTypeValueWrapper().setValue(((QuantityTypeRadioButton)newValue).getType());
    }


    
}
