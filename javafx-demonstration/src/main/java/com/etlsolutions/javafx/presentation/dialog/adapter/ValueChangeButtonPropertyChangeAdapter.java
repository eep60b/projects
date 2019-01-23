package com.etlsolutions.javafx.presentation.dialog.adapter;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Button;

/**
 *
 * @author zc
 * @param <T>
 */
public class ValueChangeButtonPropertyChangeAdapter<T> implements PropertyChangeListener {

    private final Button[] buttons;

    public ValueChangeButtonPropertyChangeAdapter(Button... buttons) {
        this.buttons = buttons;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ValueWrapper<T> wrapper = (ValueWrapper<T>) evt.getSource();
        for(Button button : buttons) {
            button.setDisable(wrapper.getValue() == null);
        }
    }
    
}
