package com.etlsolutions.javafx.presentation.menu.add.growingmedium;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class OrganicMaterialPercentageChangeAdapter implements ChangeListener<String> {

    private final AddGrowingMediumDataModel model;

    public OrganicMaterialPercentageChangeAdapter(AddGrowingMediumDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        model.setOrganicPercentage(Double.parseDouble(newValue));
    }
    
}
