package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskToLocationPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<Location> toLocationComboBox;

    public TransplantTaskToLocationPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<Location> toLocationComboBox) {
        this.model = model;
        this.toLocationComboBox = toLocationComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        toLocationComboBox.getSelectionModel().select(model.getToLocation().getValue());
    }
}
