package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.plant.GrowingMedium;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 *
 * @author zc
 */
public class GrowingMediumChangeAdapter implements ChangeListener<SingleSelectionModel<GrowingMedium>> {

    private final AddPlantsDataModel model;

    public GrowingMediumChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }
    
    @Override
    public void changed(ObservableValue<? extends SingleSelectionModel<GrowingMedium>> observable, SingleSelectionModel<GrowingMedium> oldValue, SingleSelectionModel<GrowingMedium> newValue) {
        model.setSelectedGrowingMedium(newValue.getSelectedItem());
    }
    
}
