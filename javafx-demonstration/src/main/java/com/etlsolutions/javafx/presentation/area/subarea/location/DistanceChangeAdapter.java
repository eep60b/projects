package com.etlsolutions.javafx.presentation.area.subarea.location;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class DistanceChangeAdapter implements ChangeListener<String> {

    private final GroundLocationMeasurementDataModel model;

    public DistanceChangeAdapter(GroundLocationMeasurementDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setDistance(newValue);
    }
}
