package com.etlsolutions.javafx.presentation.log.task;

import com.etlsolutions.javafx.data.area.subarea.SubArea;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 */
public class TransplantTaskFromSubAreaPropertyChangeAdapter implements PropertyChangeListener {

    private final TransplantTaskDataModel model;
    private final ComboBox<SubArea> fromSubAreaComboBox;

    public TransplantTaskFromSubAreaPropertyChangeAdapter(TransplantTaskDataModel model, ComboBox<SubArea> fromSubAreaComboBox) {
        this.model = model;
        this.fromSubAreaComboBox = fromSubAreaComboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fromSubAreaComboBox.getSelectionModel().select(model.getSelectedFromSubArea().getValue());
        model.getFromLocations().clear();
        model.getFromLocations().addAll(model.getSelectedFromSubArea().getValue().getAllLocations());
        model.getFromLocation().setValue(model.getFromLocations().get(0));
    }
    
}
