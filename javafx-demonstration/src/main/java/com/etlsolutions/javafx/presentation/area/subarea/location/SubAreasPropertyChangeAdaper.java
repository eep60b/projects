package com.etlsolutions.javafx.presentation.area.subarea.location;

import com.etlsolutions.javafx.data.area.subarea.location.LocationType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class SubAreasPropertyChangeAdaper implements PropertyChangeListener {

    private final ComboBox<LocationType> locationTypeComboBox;
    private final Button removeSubareaButton;
    private final Button editSubareaButton;

    public SubAreasPropertyChangeAdaper(ComboBox<LocationType> locationTypeComboBox, Button removeSubareaButton, Button editSubareaButton) {
        this.locationTypeComboBox = locationTypeComboBox;
        this.removeSubareaButton = removeSubareaButton;
        this.editSubareaButton = editSubareaButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        AddLocationDataModel model = (AddLocationDataModel) evt.getSource();
        locationTypeComboBox.setItems(model.getTypes());
        locationTypeComboBox.getSelectionModel().select(model.getSelectedType());
        locationTypeComboBox.setDisable(model.getTypes().size() <= 1);
        removeSubareaButton.setDisable(model.getSubAreas().isEmpty());
        editSubareaButton.setDisable(model.getSubAreas().isEmpty());
    }

}
