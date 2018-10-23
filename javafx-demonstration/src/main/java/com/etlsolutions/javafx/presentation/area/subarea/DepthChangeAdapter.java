package com.etlsolutions.javafx.presentation.area.subarea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class DepthChangeAdapter implements ChangeListener<String> {

    private final DepthDataModel model;

    public DepthChangeAdapter(DepthDataModel model) {
        this.model = model;
    }
    
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setDepth(newValue);
    }
}