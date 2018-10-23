package com.etlsolutions.javafx.presentation.area.subarea;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class VolumeChangeAdapter implements ChangeListener<String> {

    private final ContainerDataModel model;

    public VolumeChangeAdapter(ContainerDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setVolume(newValue);
    }
}
