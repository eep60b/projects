package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AreaSelectionChangeAdaper implements ChangeListener<Area> {

    private final AbstractLocationDataModel model;

    public AreaSelectionChangeAdaper(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Area> observable, Area oldValue, Area newValue) {
        model.setSelectedArea(newValue);
    }
}
