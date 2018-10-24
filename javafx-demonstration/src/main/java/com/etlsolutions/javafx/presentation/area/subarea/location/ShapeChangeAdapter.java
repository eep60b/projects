package com.etlsolutions.javafx.presentation.area.subarea.location;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class ShapeChangeAdapter implements ChangeListener<String> {

    private final ContainerDataModel model;

    public ShapeChangeAdapter(ContainerDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setShape(newValue);
    }
    
}
