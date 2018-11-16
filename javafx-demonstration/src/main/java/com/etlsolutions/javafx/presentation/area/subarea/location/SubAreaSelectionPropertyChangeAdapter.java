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

    private final AbstractLocationDataModel model;
    private final ComboBox<LocationType> locationTypeComboBox;

    public SubAreaSelectionPropertyChangeAdapter(AbstractLocationDataModel model, ComboBox<LocationType> locationTypeComboBox) {
        this.model = model;
        this.locationTypeComboBox = locationTypeComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        locationTypeComboBox.setItems(model.getTypes());
    }

}
