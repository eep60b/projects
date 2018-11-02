package com.etlsolutions.javafx.presentation.menu.add.gvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class FlowerTypeChangeAdapter implements ChangeListener<String> {

    private final FloweringGventDetailDataModel model;

    public FlowerTypeChangeAdapter(FloweringGventDetailDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setFlowerType(newValue);
    }    
}
