package com.etlsolutions.javafx.presentation.dialog.area;

import com.etlsolutions.javafx.data.area.measurement.AreaMeasurable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.TextField;

/**
 *
 * @author zc
 */
public class AreaMeasurablePropertyChangeAdapter implements PropertyChangeListener {

    private final AreaMeasurable model;
    private final TextField areaValueTextField;

    public AreaMeasurablePropertyChangeAdapter(AreaMeasurable model, TextField areaValueTextField) {
        this.model = model;
        this.areaValueTextField = areaValueTextField;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        areaValueTextField.setText(model.getAreaString());
    }
}
