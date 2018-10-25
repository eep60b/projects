package com.etlsolutions.javafx.presentation.area.subarea.location;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class OccupiedAreaChangeAdapter implements ChangeListener<String> {

    private final GroundLocationMeasurementDataModel model;

    public OccupiedAreaChangeAdapter(GroundLocationMeasurementDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setOccupiedArea(newValue);
    }
}
