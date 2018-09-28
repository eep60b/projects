package com.etlsolutions.javafx.presentation.menu.add.plants;

import com.etlsolutions.javafx.data.log.gvent.Gvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionModel;

/**
 *
 * @author zc
 */
public class EventSelectionChangeAdapter implements ChangeListener<SelectionModel<Gvent>> {

    private final AddPlantsDataModel model;

    public EventSelectionChangeAdapter(AddPlantsDataModel model) {
        this.model = model;
    }

    @Override
    public void changed(ObservableValue<? extends SelectionModel<Gvent>> observable, SelectionModel<Gvent> oldValue, SelectionModel<Gvent> newValue) {
        model.setSelectedEvent(newValue.getSelectedItem());
    }
    
}
