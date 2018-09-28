package com.etlsolutions.javafx.presentation.menu.add.plants;

import java.time.LocalDateTime;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class TerminationDateChangeAdapter implements ChangeListener<LocalDateTime>{

    private final AddPlantsDataModel model;

    public TerminationDateChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends LocalDateTime> observable, LocalDateTime oldValue, LocalDateTime newValue) {
        model.setTerminationDate(newValue);
    }
    
}
