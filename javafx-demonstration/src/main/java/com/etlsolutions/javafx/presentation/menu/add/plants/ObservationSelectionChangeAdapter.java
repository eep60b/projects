package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.GrowingObservation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class ObservationSelectionChangeAdapter implements ChangeListener<SelectionModel<GrowingObservation>> {

    private final AddPlantsDataModel model;

    public ObservationSelectionChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<GrowingObservation>> observable, SelectionModel<GrowingObservation> oldValue, SelectionModel<GrowingObservation> newValue) {
        model.setSelectedGrowingObservation(newValue.getSelectedItem());
    }
    
}
