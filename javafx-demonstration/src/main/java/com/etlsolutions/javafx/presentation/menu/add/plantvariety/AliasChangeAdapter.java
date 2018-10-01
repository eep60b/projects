package com.etlsolutions.javafx.presentation.menu.add.plantvariety;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class AliasChangeAdapter implements ChangeListener<String> {

    private final AddVarietyDialogDataModel model;

    public AliasChangeAdapter(AddVarietyDialogDataModel model) {
        
        this.model = model;
    }

    @Override
    public void changed(ObservableValue observable, String oldValue, String newValue) {
        model.setSelectedAlias(newValue);
    }
}
