package com.etlsolutions.javafx.presentation.log;

import com.etlsolutions.javafx.data.log.NotificationTimeUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class NotificationTimeUnitChangeAdapter implements ChangeListener<NotificationTimeUnit> {

    private final NotificationDataModel model;

    public NotificationTimeUnitChangeAdapter(NotificationDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends NotificationTimeUnit> observable, NotificationTimeUnit oldValue, NotificationTimeUnit newValue) {
        
        model.setSelectedTimeUnit(newValue);
    }
    
}
