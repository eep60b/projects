package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.Area;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskToAreaPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<Area> toAreaComboBox;

    public TransplantTaskToAreaPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<Area> toAreaComboBox) {
        this.model = model;
        this.toAreaComboBox = toAreaComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        toAreaComboBox.getSelectionModel().select(model.getSelectedToArea().getValue());
        model.getToSubAreas().clear();
        model.getToSubAreas().addAll(model.getSelectedToArea().getValue().getAllSubAreas());
        model.getSelectedToSubArea().setValue(model.getToSubAreas().get(0));
    }
    
}
