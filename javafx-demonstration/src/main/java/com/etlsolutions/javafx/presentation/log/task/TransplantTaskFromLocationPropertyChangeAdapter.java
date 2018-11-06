package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.subarea.location.Location;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskFromLocationPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<Location> fromLocationComboBox;

    public TransplantTaskFromLocationPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<Location> fromLocationComboBox) {
        this.model = model;
        this.fromLocationComboBox = fromLocationComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fromLocationComboBox.getSelectionModel().select(model.getFromLocation().getValue());
    }
}
