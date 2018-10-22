package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class LocationTypeSelectionChangeAdaper implements ChangeListener<SingleSelectionModel<LocationType>> {

    private final AddLocationDataModel model;

    public LocationTypeSelectionChangeAdaper(AddLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<LocationType>> observable, SingleSelectionModel<LocationType> oldValue, SingleSelectionModel<LocationType> newValue) {
          model.setSelectedType(newValue.getSelectedItem());
    }

}