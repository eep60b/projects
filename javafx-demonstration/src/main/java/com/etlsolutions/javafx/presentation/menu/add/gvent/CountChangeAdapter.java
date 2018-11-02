package com.etlsolutions.javafx.presentation.menu.add.gvent;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class CountChangeAdapter implements ChangeListener<Integer> {

    private final FloweringGventDetailDataModel model;

    public CountChangeAdapter(FloweringGventDetailDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
        model.setCount(newValue);
    }
    
}
