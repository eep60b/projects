package com.etlsolutions.javafx.presentation.log.gvent;

import com.etlsolutions.javafx.data.ValueWrapper;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.layout.HBox;

/**
 *
 * @author zc
 */
public class ValuePropertyChangeAdapter implements PropertyChangeListener {

    private final HBox countHBox;

    public ValuePropertyChangeAdapter(HBox countHBox) {
        this.countHBox = countHBox;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        ValueWrapper<Boolean> wrapper = (ValueWrapper<Boolean>) evt.getSource();
        countHBox.setVisible(wrapper.getValue());
    }
}
