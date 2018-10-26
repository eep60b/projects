package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class LocationTypeListChangeAdapter implements ListChangeListener<LocationType> {

    private final ComboBox<LocationType> locationTypeComboBox;
    private final AbstractLocationDataModel model;

    public LocationTypeListChangeAdapter(ComboBox<LocationType> locationTypeComboBox, AbstractLocationDataModel model) {
        this.locationTypeComboBox = locationTypeComboBox;
        this.model = model;
    }

    @Override
    public void onChanged(Change<? extends LocationType> c) {
        locationTypeComboBox.setItems(model.getTypes());
    }
}
