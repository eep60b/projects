package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class IsAliveChangeAdapter implements ChangeListener<Boolean> {

    private final AddPlantsDataModel model;

    public IsAliveChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        model.setAlive(newValue);
    }
    
}
