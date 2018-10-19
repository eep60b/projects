package com.etlsolutions.javafx.presentation.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
public class DiameterChangeAdapter implements ChangeListener<String> {

    private final CircleDataModel model;
    private final TextField areaValueTextField;

    public DiameterChangeAdapter(CircleDataModel model, TextField areaValueTextField) {
        this.model = model;
        this.areaValueTextField = areaValueTextField;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setDiameter(newValue);
        areaValueTextField.setText(model.getAreaValue());
    }

}
