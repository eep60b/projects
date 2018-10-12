package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class StonePercentageChangeAdapter implements ChangeListener<String> {

    private final AddGrowingMediumDataModel model;

    public StonePercentageChangeAdapter(AddGrowingMediumDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setStonePercentage(Double.parseDouble(newValue));
    }
    
}
