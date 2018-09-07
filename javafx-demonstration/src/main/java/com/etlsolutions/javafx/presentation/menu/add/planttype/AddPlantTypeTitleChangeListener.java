
package com.etlsolutions.javafx.presentation.menu.add.planttype;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class AddPlantTypeTitleChangeListener implements ChangeListener<String> {

    private final AddPlantTypeDialogDataModel model;

    public AddPlantTypeTitleChangeListener(AddPlantTypeDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setTitle(newValue);
    }    
}
