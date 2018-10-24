package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class LocationTypeSelectionChangeAdaper implements ChangeListener<LocationType> {

    private final AbstractLocationDataModel model;

    public LocationTypeSelectionChangeAdaper(AbstractLocationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends LocationType> observable, LocationType oldValue, LocationType newValue) {
          model.setSelectedType(newValue);
    }

}