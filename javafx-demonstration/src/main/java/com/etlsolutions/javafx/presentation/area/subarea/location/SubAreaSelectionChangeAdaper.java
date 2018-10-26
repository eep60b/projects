package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreaSelectionChangeAdaper implements ChangeListener<SubArea> {

    private final AbstractLocationDataModel model;
    private final ComboBox<LocationType> locationTypeComboBox;

    public SubAreaSelectionChangeAdaper(AbstractLocationDataModel model, ComboBox<LocationType> locationTypeComboBox) {
        this.model = model;
        this.locationTypeComboBox = locationTypeComboBox;
    }

    @Override
    public void changed(ObservableValue<? extends SubArea> observable, SubArea oldValue, SubArea newValue) {
        model.setSelectedSubArea(newValue);

        locationTypeComboBox.setItems(model.getTypes());
        locationTypeComboBox.getSelectionModel().select(model.getSelectedType());
    }
}
