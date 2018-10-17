package com.etlsolutions.javafx.presentation.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class DiameterChangeAdapter implements ChangeListener<String> {

    private final AbstractAreaDataModel model;

    public DiameterChangeAdapter(AbstractAreaDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setDiameter(Double.parseDouble(newValue));
    }

}
