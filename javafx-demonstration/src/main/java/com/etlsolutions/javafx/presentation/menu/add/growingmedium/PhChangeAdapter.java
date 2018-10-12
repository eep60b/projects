package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class PhChangeAdapter implements ChangeListener<String> {

    private final AddGrowingMediumDataModel model;

    public PhChangeAdapter(AddGrowingMediumDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setPh(Double.parseDouble(newValue));
    }
    
}
