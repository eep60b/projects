package com.etlsolutions.javafx.presentation.dialog.adapter;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 * @param <T>
 */
public class ComboBoxSelectionPropertyChangeAdapter<T> implements PropertyChangeListener {

    private final ComboBox<T> comboBox;

    public ComboBoxSelectionPropertyChangeAdapter(ComboBox<T> comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<T> wrapper = (ValueWrapper<T>)evt.getSource();
        comboBox.getSelectionModel().select(wrapper.getValue());
    }
}
