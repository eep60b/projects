package com.etlsolutions.javafx.presentation.menu.add.area;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class SideChangeAdapter implements ChangeListener<String> {

    private final AddAreaDialogDataModel model;

    public SideChangeAdapter(AddAreaDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setSide(Double.parseDouble(newValue));
    }
    
}