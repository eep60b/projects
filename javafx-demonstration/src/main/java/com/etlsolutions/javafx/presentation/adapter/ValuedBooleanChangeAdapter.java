package com.etlsolutions.javafx.presentation.adapter;

import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 * @param <T>
 */
public class ValuedBooleanChangeAdapter<T> implements ChangeListener<Boolean> {

    private final ValueWrapper<T> wateringType;
    private final T type;

    public ValuedBooleanChangeAdapter(ValueWrapper<T> wrapper, T type) {
        this.wateringType = wrapper;
        this.type = type;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(newValue) {
            wateringType.setValue(type);
        }
    }
}
