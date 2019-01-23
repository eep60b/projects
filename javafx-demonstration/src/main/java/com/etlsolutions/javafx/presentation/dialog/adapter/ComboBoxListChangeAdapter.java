package com.etlsolutions.javafx.presentation.dialog.adapter;

import com.etlsolutions.javafx.data.ObservableListWrapperA;
import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;

/**
 *
 * @author zc
 * @param <T>
 */
public class ComboBoxListChangeAdapter<T> implements ListChangeListener<T> {

    private final ObservableListWrapperA<T> list;
    private final ComboBox<T> comboBox;
    private final ValueWrapper<T> valueWrpper;

    public ComboBoxListChangeAdapter(ObservableListWrapperA<T> list, ComboBox<T> comboBox, ValueWrapper<T> valueWrpper) {
        this.list = list;
        this.comboBox = comboBox;
        this.valueWrpper = valueWrpper;
    }

    @Override
    public void onChanged(Change<? extends T> c) {
        comboBox.setItems(list);

        int index = list.indexOf(valueWrpper.getValue());
        if (list.isEmpty()) {
            comboBox.getSelectionModel().select(null);
            return;
        }
        if (index < 0) {
            comboBox.getSelectionModel().select(0);
            return;
        }
        comboBox.getSelectionModel().select(index);
    }
}
