package com.etlsolutions.javafx.presentation.area.subarea.location;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class DirectionChangeAdapter implements ChangeListener<String> {

    private final GroundLocationMeasurementDataModel model;

    public DirectionChangeAdapter(GroundLocationMeasurementDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setDirection(newValue);
    }
}