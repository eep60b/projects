package com.etlsolutions.javafx.presentation.menu.add.plants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
public class PlantNumberChangeAdapter implements ChangeListener<Integer> {

    private final AddPlantsDataModel model;

    public PlantNumberChangeAdapter(AddPlantsDataModel model) {
        
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
        model.setPlantNumber(newValue);
    }
}
