package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskToSubAreaPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<SubArea> toSubAreaComboBox;

    public TransplantTaskToSubAreaPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<SubArea> toSubAreaComboBox) {
        this.model = model;
        this.toSubAreaComboBox = toSubAreaComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        toSubAreaComboBox.getSelectionModel().select(model.getSelectedToSubArea().getValue());
        model.getToLocations().clear();
        model.getToLocations().addAll(model.getSelectedToSubArea().getValue().getAllLocations());
        model.getToLocation().setValue(model.getToLocations().get(0));
    }
    
}
