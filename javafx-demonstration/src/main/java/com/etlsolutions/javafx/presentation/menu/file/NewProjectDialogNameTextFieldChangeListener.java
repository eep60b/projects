package com.etlsolutions.javafx.presentation.menu.file;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class NewProjectDialogNameTextFieldChangeListener implements ChangeListener<String> {

    private final NewProjectDialogDataModel model;

    public NewProjectDialogNameTextFieldChangeListener(NewProjectDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setName(newValue);
    }
}
