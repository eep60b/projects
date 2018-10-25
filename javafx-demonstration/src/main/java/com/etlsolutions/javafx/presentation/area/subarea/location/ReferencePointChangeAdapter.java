package com.etlsolutions.javafx.presentation.area.subarea.location;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class ReferencePointChangeAdapter implements ChangeListener<String> {

    private final GroundLocationMeasurementDataModel model;

    public ReferencePointChangeAdapter(GroundLocationMeasurementDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setReferencePoint(newValue);
    }
    
}