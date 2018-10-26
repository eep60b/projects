package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreaSelectionPropertyChangeAdapter implements PropertyChangeListener {

    private final ComboBox<LocationType> locationTypeComboBox;

    public SubAreaSelectionPropertyChangeAdapter(ComboBox<LocationType> locationTypeComboBox) {
        this.locationTypeComboBox = locationTypeComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AddLocationDataModel model = (AddLocationDataModel) evt.getSource();
        locationTypeComboBox.setItems(model.getTypes());
    }

}
