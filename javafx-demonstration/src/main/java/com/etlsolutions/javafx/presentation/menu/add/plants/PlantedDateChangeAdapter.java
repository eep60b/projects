package com.etlsolutions.javafx.presentation.menu.add.plants;

import java.time.LocalDateTime;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author zc
 */
class PlantedDateChangeAdapter implements ChangeListener<LocalDateTime>{

    private final AddPlantsDataModel model;

    public PlantedDateChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends LocalDateTime> observable, LocalDateTime oldValue, LocalDateTime newValue) {
        model.setPlantedDate(newValue);
    }
    
}
