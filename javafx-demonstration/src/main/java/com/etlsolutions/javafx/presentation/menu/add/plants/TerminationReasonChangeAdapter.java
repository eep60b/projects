package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class TerminationReasonChangeAdapter implements ChangeListener<String> {

    private final AddPlantsDataModel model;

    public TerminationReasonChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setTerminationReason(newValue);
    }
    
}
