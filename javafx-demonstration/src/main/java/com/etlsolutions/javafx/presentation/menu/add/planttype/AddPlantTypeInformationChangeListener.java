
package com.etlsolutions.javafx.presentation.menu.add.planttype;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class AddPlantTypeInformationChangeListener implements ChangeListener<String> {

    private final PlantTypeDialogDataModel model;

    public AddPlantTypeInformationChangeListener(PlantTypeDialogDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setInformation(newValue);
    }    
}
