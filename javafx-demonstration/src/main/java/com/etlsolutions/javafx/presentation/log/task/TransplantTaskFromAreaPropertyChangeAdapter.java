package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.Area;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskFromAreaPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<Area> fromAreaComboBox;

    public TransplantTaskFromAreaPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<Area> fromAreaComboBox) {
        this.model = model;
        this.fromAreaComboBox = fromAreaComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fromAreaComboBox.getSelectionModel().select(model.getSelectedFromArea().getValue());
        model.getFromSubAreas().clear();
        model.getFromSubAreas().addAll(model.getSelectedFromArea().getValue().getAllSubAreas());
        model.getSelectedFromSubArea().setValue(model.getFromSubAreas().get(0));
    }
    
}
