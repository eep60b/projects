package com.etlsolutions.javafx.presentation.menu.file;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class NewProjectDialogPathTextFieldChangeListener implements ChangeListener<String> {

    private final NewProjectDialogDataModel model;

    public NewProjectDialogPathTextFieldChangeListener(NewProjectDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setPath(newValue);
    }
}
