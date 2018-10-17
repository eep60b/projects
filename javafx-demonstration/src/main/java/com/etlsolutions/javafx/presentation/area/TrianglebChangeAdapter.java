package com.etlsolutions.javafx.presentation.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class TrianglebChangeAdapter implements ChangeListener<String> {

    private final AbstractAreaDataModel model;

    public TrianglebChangeAdapter(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setB(Double.parseDouble(newValue));
    }
    
}