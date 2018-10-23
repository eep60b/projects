package com.etlsolutions.javafx.presentation.area.subarea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class HeightChangeAdapter implements ChangeListener<String> {

    private final HeightDataModel model;

    public HeightChangeAdapter(HeightDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setHeight(newValue);
    }
}
