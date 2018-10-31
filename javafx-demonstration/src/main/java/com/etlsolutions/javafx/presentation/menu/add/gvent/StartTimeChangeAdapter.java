package com.etlsolutions.javafx.presentation.menu.add.gvent;

import java.time.LocalDateTime;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Zhipeng
 */
public class StartTimeChangeAdapter implements ChangeListener<LocalDateTime> {

    private final AbstractGventDataModel model;

    public StartTimeChangeAdapter(AbstractGventDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends LocalDateTime> observable, LocalDateTime oldValue, LocalDateTime newValue) {
        model.setStartTime(newValue);
    }
    
}
