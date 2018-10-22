package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.Area;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class AreaSelectionChangeAdaper implements ChangeListener<SingleSelectionModel<Area>> {

    private final AddLocationDataModel model;

    public AreaSelectionChangeAdaper(AddLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<Area>> observable, SingleSelectionModel<Area> oldValue, SingleSelectionModel<Area> newValue) {
        model.setSelectedArea(newValue.getSelectedItem());
    }
}
