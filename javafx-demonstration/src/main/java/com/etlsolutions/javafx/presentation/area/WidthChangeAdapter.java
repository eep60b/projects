package com.etlsolutions.javafx.presentation.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
public class WidthChangeAdapter implements ChangeListener<String> {

    private final LengthWidthDataModel model;
    private final TextField areaValueTextField;

    public WidthChangeAdapter(LengthWidthDataModel model, TextField areaValueTextField) {
        this.model = model;
        this.areaValueTextField = areaValueTextField;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setWidth(newValue);
        areaValueTextField.setText(model.getAreaValue());
    }

}
