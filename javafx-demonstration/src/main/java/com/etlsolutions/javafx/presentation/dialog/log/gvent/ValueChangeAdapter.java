
package com.etlsolutions.javafx.presentation.dialog.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 * @param <T>
 */
public class ValueChangeAdapter<T> implements ChangeListener<T> {

    private final ValueWrapper<T> wrapper;

    public ValueChangeAdapter(ValueWrapper<T> wrapper) {
        
        this.wrapper = wrapper;
    }

    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
        wrapper.setValue(newValue);
    }
    
}
