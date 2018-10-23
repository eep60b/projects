package com.etlsolutions.javafx.presentation.area.subarea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class NumberChangeAdapter implements ChangeListener<String> {

    private final ContainerSetDataModel model;

    public NumberChangeAdapter(ContainerSetDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setNumber(newValue);
    }
    
}

