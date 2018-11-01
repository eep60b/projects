package com.etlsolutions.javafx.presentation.log;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class LengthBeforeValueChangeAdapter implements ChangeListener<Integer> {

    private final NotificationDataModel model;

    
    public LengthBeforeValueChangeAdapter(NotificationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
        model.setLengthBefore(newValue);
    }
    
}
